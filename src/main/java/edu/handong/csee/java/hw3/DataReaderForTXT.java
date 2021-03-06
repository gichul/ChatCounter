package edu.handong.csee.java.hw3;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * this class is DataReaderForTXT to read data 
 * @author gichulkim
 *
 */

public class DataReaderForTXT {
	
	Date d;
	String name,time,date,message;
	ArrayList<String> unitedData = new ArrayList<>();
	
	private String fileName; 
	/**
	 * this is Constructor
	 * @param fileName
	 */
	public DataReaderForTXT(String fileName) {
		this.fileName=fileName;
	}		// TODO Auto-generated constructor stub
	
	/**
	 * distinguish the contents of TxtFile 
	 * @param fileName
	 */
	public  void readTxtFile(String fileName) {
		Scanner inputStream=null;
		try {
			inputStream=new Scanner(new File(fileName));   //무슨 읜미가 있길래 ??
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(inputStream.hasNextLine()) {
		
			String line=inputStream.nextLine();
			
			

			if(line.contains("-----")) {

				SimpleDateFormat originalForm = new SimpleDateFormat("yyyy년 mm월 dd");				
				SimpleDateFormat transForm = new SimpleDateFormat("yyyy-mm-dd");
				
				try {
					d = originalForm.parse(line.substring(15,28));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				date = transForm.format(d);
				
				
			}	
			else if(line.contains("[")&&line.contains("]")) {
				String[] data = line.split("] ");
				name = data[0].substring(1, data[0].length());
				message = data[2];
				
				SimpleDateFormat oldTime = new SimpleDateFormat("a hh:mm");
				SimpleDateFormat newTime = new SimpleDateFormat("hh:mm");
				
				try {
					d = oldTime.parse(data[1].substring(1,data[1].length()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				time = newTime.format(d);
				unitedData.add(date +" " +time +"   "+"\""+name+"\"\"" +message+"\"");
			}
			
		}
		inputStream.close();
		
	}

}





