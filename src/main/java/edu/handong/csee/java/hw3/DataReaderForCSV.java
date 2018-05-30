package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * DataReaderForCSV class to read the data
 * @author gichulkim
 *
 */
public class DataReaderForCSV {

	ArrayList<String> unitedData = new ArrayList<>();
	private String fileName; 
	
	/**
	 * constructor of DataReaderForCSV
	 * @param fileName
	 */
	public DataReaderForCSV(String fileName) {
		this.fileName=fileName;
	}		// TODO Auto-generated constructor stub
	
	/**
	 * distinguish the data of TxtFile
	 * readTxtFile 
	 */
	public void readTxtFile() {
		
		try {
			Scanner inputStream = new Scanner(new File(fileName)); 
			String line;
			
			while (inputStream.hasNextLine()) {
				// Contains date,name,message
				line = inputStream.nextLine();
				
				if(line.contains("2018")) {
				String[] contents = line.split(",");
				
				String time=contents[0];
				String name=contents[1];
				String message=contents[2];

				unitedData.add(time+name+message);
			//	System.out.println(time + name + message);	
				}
			}
			
		
			inputStream.close( );
		}
			
		
		catch(FileNotFoundException e)
		{
			System.out.println("Can not find file "+ fileName);
		}
		
		
	}
	

}
