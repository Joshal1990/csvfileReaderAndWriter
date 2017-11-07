package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvWriter;

public class CSVUtils {

	public static ArrayList<String[]> readCSV() {
		String csvFile = "C:/john/SampleCSVFile.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] rowCsv = null;
		ArrayList<String[]> csvfile = new ArrayList<String[]>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				rowCsv = line.split(cvsSplitBy);
				csvfile.add(rowCsv);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("csv file reader completed!");
		return csvfile;

	}

	public static void writeCSV(ArrayList<String[]> readCSV) {

		String outputFile = "C:/john/users.csv";

		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();

		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(
					new FileWriter(outputFile, true), ',');

			// if the file didn't already exist then we need to write out the
			// header line
			/*
			 * if (!alreadyExists) { csvOutput.write("id");
			 * csvOutput.write("name"); csvOutput.endRecord(); }
			 */
			// else assume that the file already has the correct header line

			// write out a few records
			/*
			 * csvOutput.write("1"); csvOutput.write("Bruce");
			 * csvOutput.endRecord();
			 * 
			 * csvOutput.write("2"); csvOutput.write("John");
			 * csvOutput.endRecord();
			 */

			for (String[] rowCsv : readCSV) {
				for (int i = 0; i < rowCsv.length; i++) {
					csvOutput.write(rowCsv[i]);
				}
				csvOutput.endRecord();
			}
			System.out.println("csv file write completed!!");
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
