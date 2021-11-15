package application;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetStudent1 = {{1,2,3},{4,5},{6,7,8}};
	private double[][] dataSetStudent2 = {{7,2,9,4},{5},{8,1,3},{11,6,7,2}};
	private double[][] dataSetStudent3 = {{7.2,2.5,9.3},{5.9},{8.1,1.7,3.3},{11.6,6.9,7.3,2.7}};
	private double[][] dataSetStudent4 = {{-2.5,-5.3,6.1},{-4.4,8.2},{2.3,-7.5},{-4.2,7.3,-5.9,2.6}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetStudent1 = dataSetStudent2 = dataSetStudent3 = dataSetStudent4 = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(36.0,TwoDimRaggedArrayUtility.getTotal(dataSetStudent1),.001);
		assertEquals(65.0,TwoDimRaggedArrayUtility.getTotal(dataSetStudent2),.001);
		assertEquals(66.5,TwoDimRaggedArrayUtility.getTotal(dataSetStudent3),.001);
		assertEquals(-3.3,TwoDimRaggedArrayUtility.getTotal(dataSetStudent4),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(4.5,TwoDimRaggedArrayUtility.getAverage(dataSetStudent1),.001);
		assertEquals(5.417,TwoDimRaggedArrayUtility.getAverage(dataSetStudent2),.001);
		assertEquals(6.045,TwoDimRaggedArrayUtility.getAverage(dataSetStudent3),.001);
		assertEquals(-.3,TwoDimRaggedArrayUtility.getAverage(dataSetStudent4),.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent1,1),.001);
		assertEquals(5.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent2,1),.001);
		assertEquals(22.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent2,0),.001);
		assertEquals(28.5,TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent3,3),.001);
		assertEquals(5.9,TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent3,1),.001);
		assertEquals(3.8,TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent4,1),.001);
		assertEquals(-.2,TwoDimRaggedArrayUtility.getRowTotal(dataSetStudent4,3),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(11.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent1,0),.001);
		assertEquals(19.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent2,2),.001);
		assertEquals(11.1,TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent3,1),.001);
		assertEquals(-8.8,TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent4,0),.001);
		assertEquals(2.7,TwoDimRaggedArrayUtility.getColumnTotal(dataSetStudent4,1),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(8.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetStudent1),.001);
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetStudent2),.001);
		assertEquals(11.6,TwoDimRaggedArrayUtility.getHighestInArray(dataSetStudent3),.001);
		assertEquals(8.2,TwoDimRaggedArrayUtility.getHighestInArray(dataSetStudent4),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetStudent4, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(-2.5, array[0][0],.001);
		assertEquals(-5.3, array[0][1],.001);
		assertEquals(6.1, array[0][2],.001);
		assertEquals(-4.4, array[1][0],.001);
		assertEquals(8.2, array[1][1],.001);
		assertEquals(2.3, array[2][0],.001);
		assertEquals(-7.5, array[2][1],.001);
		assertEquals(-4.2, array[3][0],.001);
		assertEquals(7.3, array[3][1],.001);
		assertEquals(-5.9, array[3][2],.001);
		assertEquals(2.6, array[3][3],.001);	
	}

}