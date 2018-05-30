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
	public ChatMessageCounter(ArrayList<String> contents) {
		this.list=contents;
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
		for(int i=0;i<list.size();i++) {
		int idx=list.get(i).indexOf("\"\"");
		
		date=list.get(i).substring(0,16);
		name=(list.get(i).substring(20,idx));
		message=list.get(i).substring(idx+2);
		person.add(name);
		}
	}
	
	

	
	

}


