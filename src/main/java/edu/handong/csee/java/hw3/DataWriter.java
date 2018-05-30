package edu.handong.csee.java.hw3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * DataWriter class to write csv file on Memory
 * @author gichulkim
 *
 */
public class DataWriter {
	
	HashMap<String, Integer> list;
	ArrayList<String> names;
/**
 * construntor of DataWriter
 * @param list
 * @param name
 */
	public DataWriter(HashMap<String, Integer> list, ArrayList<String> name) {
		this.list=list;
		this.names=name;
	}
	
/**
 * input the data to csv file
 * @param filePath
 */
	void run(String filePath) {
		String fileName = "ChatCounter.csv";
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(filePath+"/"+fileName);
		} catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		outputStream.println("kakao_id,name");
        for (String s: list.keySet()) {
            String line = s + ","+list.get(s);
            outputStream.println (line);
        }
        outputStream.close();
        System.out.println ("Those lines were written to " + fileName);
	}


}