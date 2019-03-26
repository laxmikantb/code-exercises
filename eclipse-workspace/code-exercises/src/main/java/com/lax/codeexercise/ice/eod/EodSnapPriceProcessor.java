package com.lax.codeexercise.ice.eod;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Requirement: A CUSIP is a unique identifier of a security. You can assume a
 * CUSIP is just an 8-character alphanumeric string. Think of the file as a
 * record of a day's prices for a set of securities identified by their CUSIPs.
 * 
 * Each CUSIP may have any number of prices (e.g., 95.752, 101.255) following it
 * in sequence, one per line. The prices can be considered to be ordered by time
 * in ascending order, earliest to latest.
 * 
 * Write a Java program that will print the closing (or latest) price for each
 * CUSIP in the file. There are about 3,000,000 bonds in the universe. 100
 * prices ticks during the day is not unusual. So, this file might contain 300
 * million lines, so your solution SHOULD NOT assume the entire file can fit in
 * memory!
 * 
 * @author laxmikant
 *  
 *         Run Parameters : <InputFileDir> <OutputFileDir>
 *         
 *         Assumption Made : There will be only one file under InputFileDir
 *         
 *         Used : Map file to MappedByteBuffer to load data in chunk.
 *         Allocate internal buffer with specifield limit.
 *         e.g. READ_BUFFER_SIZE = 100MB , we can make configurable at runtime.
 *         so that it will reduce IO file read disk io which is most be expensive
 *         
 *         Note : File content is loaded in virtual memory instead of heap and 
 *         JVM doesn’t need to call OS specific read/write system calls
 */
/**
 * @author laxbopal
 *
 */
public class EodSnapPriceProcessor {

	private static int READ_BUFFER_SIZE = 1024 * 1024 * 100; // 100 MB
	private static Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

	private final String outputDirectoryPath;
	private final String inputDirectoryPath;
	private final String outputFileName;
	
	private String cusip = null;
	private PricePoint pricePoint = null;
	private int cusipProcessed = 0;
	private File fout;
	private FileOutputStream fos;
	private BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		if (args.length < 3) {
			System.out.println("Parameters required  : <inputFilesDir> <OutputFilesDir> <OutputFileName>");
			System.exit(0);
		}
		
		EodSnapPriceProcessor eodSnapPriceProcessor = new EodSnapPriceProcessor(args[0].trim(), args[1].trim(), args[2]);
		eodSnapPriceProcessor.processEodSnapFile();
	}

	/**
	 * @throws Exception 
	 */
	public boolean processEodSnapFile() throws Exception { 
		ArrayList<String> fileNameList = new ArrayList<String>();
		getInputFiles(inputDirectoryPath, fileNameList);
		if (fileNameList.size() < 1) {
			throw new Exception("Empty Input Directory " + inputDirectoryPath);
			//return false;
		}
		String inputFileName = fileNameList.get(0);
		RandomAccessFile inputFile = new RandomAccessFile(inputFileName, "r");
		FileChannel inputChannel = inputFile.getChannel();
		if (inputChannel.size() == 0) {
			throw new Exception("Empty Input File " + inputFileName);
			//return false;
		}
		MappedByteBuffer mmb = inputChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputChannel.size());

		
		if (!generateOutputFile())
		{
			//System.out.println("Failed to create Output File");
			throw new Exception("Failed to create Output File");
			//return false;
		}
			
		int indx;
		while (true) {
			int remainingBytes = mmb.limit() - mmb.position();
			if (remainingBytes == 0) {
				inputFile.close();
				break;
			}
			byte[] buffer = null;
			if (remainingBytes >= READ_BUFFER_SIZE)
				buffer = new byte[READ_BUFFER_SIZE];
			else {
				buffer = new byte[remainingBytes];
			}

			mmb.get(buffer);
			int bytesread = buffer.length;

			indx = bytesread - 1;

			while (buffer[indx] != '\n') { 
				indx--; 
			}

			int resetPositionBy = bytesread - (indx + 1);
			mmb.position(mmb.position() - resetPositionBy);
			try (BufferedReader in = new BufferedReader(
					new InputStreamReader(new ByteArrayInputStream(buffer, 0, bytesread - resetPositionBy)))) {
				String line;
				while ((line = in.readLine()) != null) {
					processLine(line);
				}
				bw.write(pricePoint.toString() + "\n"); // Last pricePoint
			}
			bw.close();
			System.out.println("Cusip Processed " + cusipProcessed);
		}
		return true;
	}

	/**
	 * @param inputDirectoryPath
	 * @param outputDirectoryPath
	 * @param outputFileName
	 */
	public EodSnapPriceProcessor(String inputDirectoryPath, String outputDirectoryPath, String outputFileName) {
		this.inputDirectoryPath = inputDirectoryPath;
		this.outputDirectoryPath = outputDirectoryPath;
		this.outputFileName = outputFileName;
	}

	/**
	 * @return outputDirectory Name
	 */
	private String getOutputDirectoryPath() {
		return outputDirectoryPath;
	}

	/**
	 * retrives filenames from given directory location
	 * @param dirName
	 * @param fileNameList
	 */
	public static void getInputFiles(String dirName, ArrayList<String> fileNameList) {
		for (File file : getFileNames(dirName)) {
			if (file.isFile()) {
				fileNameList.add(file.getAbsolutePath());
			}
		}
	}

	/**
	 * @param directoryName
	 * @return List of fileNames
	 */
	private static List<File> getFileNames(String directoryName) {
		File directory = new File(directoryName);

		List<File> resultList = new ArrayList<File>();

		// get all the files from a directory
		File[] fList = directory.listFiles();
		resultList.addAll(Arrays.asList(fList));
		for (File file : fList) {
			if (file.isDirectory()) {
				resultList.addAll(getFileNames(file.getAbsolutePath()));
			}
		}
		return resultList;
	}

	/**
	 * @return success if output file been created
	 */
	public boolean generateOutputFile() {
		String outputFilePath = getOutputDirectoryPath() + "//" + outputFileName + ".out";

		try {
			fout = new File(outputFilePath);
			fos = new FileOutputStream(fout);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
		} catch (FileNotFoundException e1) {
			return false;
		}
		return true;
	}

	/**
	 * @param line
	 * @return if line contains cusip
	 */
	private String isCusipLine(String line) {
		if (line != null && (pattern.matcher(line.trim()).matches() && line.trim().length() == 8))
			return line.trim();
		return null;
	}


	/**
	 * @param strNum
	 * @return true if parsable double string
	 */
	private boolean isValidPriceString(String strNum) {
		try {
			Double.parseDouble(strNum);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	/**
	 * @param line
	 * @throws IOException if file write fails
	 */
	private void processLine(String line) throws IOException {
		if ((cusip = isCusipLine(line)) != null) {
			if (pricePoint != null) {
				bw.write(pricePoint.toString() + "\n");
				cusipProcessed++;
				pricePoint = new PricePoint(cusip, null);
			} else {
				pricePoint = new PricePoint(cusip, null);
			}
		} else {
			if (pricePoint != null)
				ProcessPriceLine(line);
		}

	}

	/**
	 * @param line
	 */
	private void ProcessPriceLine(String line) {
		if (isValidPriceString(line)) {
			pricePoint.setPrice(line.trim());
		}
	}
}
