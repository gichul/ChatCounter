package edu.handong.csee.java.hw3;

import java.io.File;
import java.util.ArrayList;

public class DataReader {
	
	public void sumOfData(String args) {
		ArrayList<String> list = new ArrayList<String>(); 
		
		String filePath=args;
		
		File files = new File(filePath); 
		File[] listOfFile = files.listFiles(); 


		String fileName ; 

		for(File f: listOfFile) { 
			fileName = f.getName();



			if(fileName.contains(".txt")) {
				DataReaderForTXT reader1 = new DataReaderForTXT(fileName ,filePath);
				for(String e: reader1.readTXT()) { 
					list.add(e);
				}
			}
			else if(fileName.contains(".csv")) {

				DataReaderForCSV reader2 = new DataReaderForCSV(fileName, filePath);
				for(String e: reader2.readCSV())
					list.add(e);

			}
			else {
				System.out.println("Can't read the format");
			}
		}
		
		
	}
	
	
	public int counter=0;
	
	public int counter(ArrayList<String> list) {
		return list;
	}
}
	
}
