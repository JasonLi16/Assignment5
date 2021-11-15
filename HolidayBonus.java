package application;

public class HolidayBonus {
	public HolidayBonus() {
	
	}
	public static double[] calculateHolidayBonus(double[][] data,double high,double low,double other) {
		double[] holidayBonus = new double [data.length];
		int row;
		for (row = 0; row < holidayBonus.length; row++){
			int column;
			for (column = 0; column < data[row].length; column++){
				if (data[row][column] >= 0) {
					if (data[row][column] == TwoDimRaggedArrayUtility.getHighestInColumn(data, column)){
						holidayBonus[row] = holidayBonus[row] + high;
					} else if (data[row][column] == TwoDimRaggedArrayUtility.getLowestInColumn(data, column)){
						holidayBonus[row] = holidayBonus[row] + low;
					} else{
						holidayBonus[row] = holidayBonus[row] + other;
					}
				}
			}
		}
		return holidayBonus;
}
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other){
		double[] bonus = calculateHolidayBonus(data, high, low, other);
		double totalHolidayBonus;
		totalHolidayBonus = 0;
		int row = 0;
		while (row < bonus.length) {
			row++;
			totalHolidayBonus = totalHolidayBonus + bonus[row];
		}
		return totalHolidayBonus;	
	}
}



