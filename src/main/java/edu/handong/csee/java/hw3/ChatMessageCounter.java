package edu.handong.csee.java.hw3;

import java.util.ArrayList;

import java.util.HashMap;

/**
 * ChatMessageCounter class to count the contents
 * @author gichulkim
 *
 */

public class ChatMessageCounter {
	
	private int counter=0;
	private String line;
	private String date,name,message;
 
	HashMap<String , Integer> result = new HashMap<String , Integer>();
	ArrayList<String> list=new ArrayList<String>();
	ArrayList<String> person=new ArrayList<String>();

	/**
	 * constructor of ChatMessageCounter
	 * @param contents
	 */
	public ChatMessageCounter() {

	}
	/**
	 * count method counting the numbers of chatting
	 */
	public void count() {
		for(String e: person) {
			if(!result.containsKey(e))
			result.put(e, 0);
		}

		for(String e: person) {
			result.replace(e, result.get(e)+1);

		}

		
		
		
	}
	
	/**
	 * split method to distinguish the data name, date, message 
	 */
	public void split() {
		
		for(int i=0;i<Home3Main.unitedData.size();i++) {
			String[] contents = Home3Main.unitedData.get(i).split("&[*]");
			
			date=contents[0];
			name=contents[1];
			message=contents[2];
			person.add(name);
			


		}
		


	}
	
	

	
	

}


