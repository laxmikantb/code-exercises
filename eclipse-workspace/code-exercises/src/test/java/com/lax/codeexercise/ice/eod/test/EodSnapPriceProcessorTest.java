package com.lax.codeexercise.ice.eod.test;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.lax.codeexercise.ice.eod.EodSnapPriceProcessor;

public class EodSnapPriceProcessorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getInputFilePathsTest() {
		ArrayList<String> fileNames = new ArrayList<String>();
		EodSnapPriceProcessor.getInputFiles("src//test//resources//input", fileNames);
		assertEquals(1, fileNames.size());
	}
	@Test
	public void generateOutputFileTest() {
		EodSnapPriceProcessor process = new EodSnapPriceProcessor(null,"src//test//resources//output",null);
		assertEquals(true, process.generateOutputFile());
	}

	
	@Test
	public void processEodSnapFileTest() throws Exception {
		EodSnapPriceProcessor process = new EodSnapPriceProcessor("src//test//resources//input","src//test//resources//output","markprice");;
		process.processEodSnapFile();
	}
	
	@Test(expected=Exception.class)
	public void ProcessFileTest_EmptyDirectory() throws Exception {
		EodSnapPriceProcessor process = new EodSnapPriceProcessor("src//test//resources//emptydirectory","src//test//resources//output","markprice");;
		process.processEodSnapFile();
	}
	
	@Test(expected=Exception.class)
	public void ProcessFileTest_EmptyFile() throws Exception {
		EodSnapPriceProcessor process = new EodSnapPriceProcessor("src//test//resources//emptyFile","src//test//resources//output","markprice");;
		process.processEodSnapFile();
	}
	
	@Test
	public void ProcessEodSnapFile_Success() throws Exception {
		EodSnapPriceProcessor process = new EodSnapPriceProcessor("src//test//resources//input","src//test//resources//output","markprice");;
		process.processEodSnapFile();
	
		Path path = Paths.get("src//test//resources//output//markprice.out");
		long lineCount = -1;
		try(Stream<String> lines = Files.lines(path).onClose(() -> { /* System.out.println("File closed"); */ }) )
		{
			lineCount = lines.count();
		}
		assertEquals(10000, lineCount);
	}
		
}
