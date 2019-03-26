package com.lax.codeexercise.ice.eod.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class GenerateDummyPriceFile {

	private static File fout;
	private static FileOutputStream fos;
	private static BufferedWriter bw;

	public static void main(String[] args) {
		/*
		 * int len = 5; String intFormatter = "%0"+len+"d";
		 * System.out.println(String.format( intFormatter, 123 ));
		 * 
		 * String inputpath = "abc.000001"; String suffix = null; if
		 * (inputpath.indexOf(".") >= 0) { suffix =
		 * inputpath.substring(inputpath.indexOf(".")+1); } inputpath = "abc."; suffix =
		 * null; if (inputpath.indexOf(".") >= 0) { suffix =
		 * inputpath.substring(inputpath.indexOf(".")+1); } inputpath = "abc"; suffix =
		 * null; if (inputpath.indexOf(".") >= 0) { suffix =
		 * inputpath.substring(inputpath.indexOf(".")+1); } generateOutputFile();
		 */

	}

	private static boolean createOutputFile() {
		try {
			fout = new File("c:\\temp\\bondprices.txt");
			fos = new FileOutputStream(fout);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
		} catch (FileNotFoundException e1) {
			return false;
		}
		return true;
	}
	private static boolean generateOutputFile() {
		if (!createOutputFile())
			return false;

		for (int noOfCusips = 0; noOfCusips < 10000; noOfCusips++) {
			String cusip = generateRandomString(8);
			try {
				bw.write(cusip + "\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int noOfPrices = getRandomNumberInRange(0, 100);
			for (int i = 0; i < noOfPrices; i++) {
				getRandomDoubleString(100, 9800);
				try {
					bw.write(getRandomDoubleString(100, 9800) + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	private static String getRandomDoubleString(int min, int max) {
		Random r = new Random();
		double randomValue = min + (max - min) * r.nextDouble();
		return String.format("%.2f", randomValue);

	}

	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static String generateRandomString(int targetStringLength) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString().toUpperCase();
		return generatedString;
	}

}

