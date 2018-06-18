package edu.handong.csee.java.hw3;

import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * DataWriter class to write csv file on Memory
 * @author gichulkim
 *
 */
public class DataWriter {

	Map<String, Integer> list;
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
		Iterator it = sortByValue(list).iterator();
		outputStream.println("kakao_id,name");

		while(it.hasNext()) {
			String temp = (String) it.next();
			outputStream.println(temp + "," + list.get(temp));
			System.out.println(temp + list.get(temp));

		}

		outputStream.close();
		System.out.println ("Those lines were writ=ten to " + fileName);

	}

	/**
	 * this method is to sort the value of hashMap.
	 * @param map
	 * @return
	 */


	public static List sortByValue(final Map map) {
		List<String> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list,new Comparator() {

			public int compare(Object o1,Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}

		});
		//  Collections.reverse(list); 
		return list;
	}



	
	
	


}