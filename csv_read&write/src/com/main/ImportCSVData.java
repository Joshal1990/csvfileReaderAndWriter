package com.main;

import java.util.ArrayList;

public class ImportCSVData {

	public static void main(String[] args) {

		ArrayList<String[]> readCSV = CSVUtils.readCSV();
		CSVUtils.writeCSV(readCSV);
	}
}
