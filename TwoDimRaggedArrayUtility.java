package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	public TwoDimRaggedArrayUtility() {
		
	}
	public static double[][] readFile(File file) throws FileNotFoundException {
		String[][] input = new String[10][10];
		Scanner files = new Scanner(file);
		int row;
		row = 0;
		int column;
		column = 0;
		while (files.hasNextLine()) {
			String[] currentRow = files.nextLine().split(" ");
			for (column = 0; column < currentRow.length; column++) {
				input[row][column] = currentRow[column];
			}
			row++;
		}
		files.close();
		double[][] sales = new double[row][];
		for (row = 0; row < sales.length; row++) {
			for (column = 0; input[row][column] != null; column++) {	
			}			
			sales[row] = new double[column];
			for (column = 0; column < sales[row].length; column++) {
				sales[row][column] = Double.parseDouble(input[row][column]);
			}
		}
		return sales;
	}
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter file = new PrintWriter(outputFile);
		int row;
		for (row = 0; row < data.length; row++) {
			int column;
			for (column = 0; column < data[row].length; column++) {
				file.print((column != 0) ? " " + data[row][column] : data[row][column]);
			}
			file.println();
		}
		file.close();
	}
	
	public static double getTotal(double[][] data) {
		double total;
		total = 0;
		int row;
		for (row = 0; row < data.length; row++) {
			int column;
			for (column = 0; column < data[row].length; column++) {
				total = total + data[row][column];
			}
		}
		return total;
	}
	

	public static double getAverage(double[][] data) {
		int count;
		count = 0;
		double total;
		total = 0;
		int row;
		for (row = 0; row < data.length; row++) {
			int column;
			for (column = 0; column < data[row].length; column++) {
				total = total + data[row][column];
				count++;
			}
		}
		return total/count;
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal;
		rowTotal = 0;
		int column;
		for (column = 0; column < data[row].length; column++) {
			rowTotal = rowTotal + data[row][column];
		}
		return rowTotal;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double columnTotal;
		columnTotal = 0;
		int row;
		for (row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				columnTotal = columnTotal + data[row][col];
			}
		}
		return columnTotal;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		int columnChecker;
		columnChecker = 0;
		double highest = data[0][0];
		while (columnChecker < data.length) {
			if (columnChecker < data[row].length) {
				highest = data[row][columnChecker];
				break;
			} else {
				columnChecker++;
			}
		}
		int column;
		for (column = 0; column < data[row].length; column++) {
			if (data[row][column] > highest) {
				highest = data[row][column];
			}
		}
		return highest;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		int highest;
		highest = 0;
		int columnChecker;
		columnChecker = 0;
		double highestInRow = data[0][0];
		while (columnChecker < data.length) {
			if (columnChecker < data[row].length) {
				highestInRow = data[row][columnChecker];
				break;
			} else {
				columnChecker++;
			}
		}
		int column = 0;
		while (column<data[row].length) {
			column++;
			if (data[row][column] > highestInRow) {
				highestInRow = data[row][column];
				highest = column;
			}
		}
		return highest;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		int columnChecker;
		columnChecker = 0;
		double lowest = data[0][0];
		while (columnChecker < data.length) {
			if (columnChecker < data[row].length) {
				lowest = data[row][columnChecker];
				break;
			} else {
				columnChecker++;
			}
		}
		int column = 0;
		while (column<data[row].length) {
			column++;
			if (data[row][column] < lowest) {
				lowest = data[row][column];
			}
		}
		return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		int lowest;
		lowest = 0;
		int columnChecker;
		columnChecker = 0;
		double lowestInRow = data[0][0];
		while (columnChecker < data.length) {
			if (columnChecker < data[row].length) {
				lowestInRow = data[row][columnChecker];
				break;
			} else {
				columnChecker++;
			}
		}
		int column = 0;
		while (column<data[row].length) {
			column++;
			if (data[row][column] < lowestInRow) {
				lowestInRow = data[row][column];
				lowest = column;
			}
		}
		return lowest;
	}
	

	public static double getHighestInColumn(double[][] data, int col) {
		int rowChecker;
		rowChecker = 0;
		double highest = data[0][0];
		while (rowChecker < data.length) {
			if (col < data[rowChecker].length) {
				highest = data[rowChecker][col];
				break;
			} else {
				rowChecker++;
			}
		}
		int row;
		for (row = 0; row < data.length; row++) {
			if (col < data[row].length)  {
				if (data[row][col] > highest) {
					highest = data[row][col];
				}
			}
		}
		return highest;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int highest;
		highest = 0;
		int rowChecker;
		rowChecker = 0;
		double highestInColumn = data[0][0];
		while (rowChecker < data.length) {
			if (col < data[rowChecker].length) {
				highestInColumn = data[rowChecker][col];
				break;
			} else {
				rowChecker++;
			}
		}
		int row;
		for (row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] > highestInColumn) {
					highestInColumn = data[row][col];
					highest = row;
				}
			}

		}
		return highest;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		int rowChecker;
		rowChecker = 0;
		double lowest = data[0][0];
		while (rowChecker < data.length) {
			if (col < data[rowChecker].length) {
				lowest = data[rowChecker][col];
				break;
			} else {
				rowChecker++;
			}
		}
		int row=0;
		while (row<data.length) {
			row++;
			if (col < data[row].length) {
				if (data[row][col] < lowest) {
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int lowest;
		lowest = 0;
		int rowChecker;
		rowChecker = 0;
		double lowestInColumn = data[0][0];
		while (rowChecker < data.length) {
			if (col < data[rowChecker].length) {
				lowestInColumn = data[rowChecker][col];
				break;
			} else {
				rowChecker++;
			}
		}
		int row=0;
		while (row<data.length) {
			row++;
			if (col < data[row].length) {
				if (data[row][col] < lowestInColumn) {
					lowestInColumn = data[row][col];
					lowest = row;
				}
			}
		}
		return lowest;
	}
	
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		int row;
		for (row = 0; row < data.length; row++) {
			int column;
			for (column = 0; column < data[row].length; column++) {
				if (data[row][column] > highest) {
					highest = data[row][column];
				}			
			}
		}
		return highest;
	}
	
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		int row=0;
		while (row<data.length) {
			row++;
			int col;
			for (col = 0; col < data[row].length; col++) {
				if (data[row][col] < lowest) {
					lowest = data[row][col];
				}			
			}
		}
		return lowest;
	}
}