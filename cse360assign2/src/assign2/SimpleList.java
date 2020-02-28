/**
 * @author London Fischer
 * Class ID: 379
 * Assignment #1
 * Version: 2.0
 * 
 * This Class creates an integer list holding up to 10 integers.
 * It contains private variables int[10] list and int count.
 * The available public methods are: add, remove, count, toString, and search
 * 
 * Version 2.0 adds methods append, first, and size. It also implements dynamic
 * resizing of the list upon addition and removal of elements.
 */
package assign2;

public class SimpleList {
	
	private int[] list;
	private int count;
	
	/** 
	 * Constructor for SimpleList Object
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Add a number to the beginning of the list
	 * Extends list by 50% if there is not enough room
	 * @param numToAdd Number to add
	 */
	public void add(int numToAdd) {
		//If list is full, extend by 50% to make room
		if(count == list.length) {
			int[] newList = new int[(count/2)*3];
			for( int i = 0; i < count; i++) {
				newList[i] = list[i];
			}
			//set list to newList and reclaim memory
			list = newList;
			newList = null;
		}
		//move elements toward end of the list
		for(int i = list.length-1; i > 0; i--) {
			list[i] = list[i-1];
		}
		list[0] = numToAdd;
		count++;
	}
	
	/**
	 * Removes the first instance of a given number from the list.
	 * @param numToRemove Number to remove
	 */
	public void remove(int numToRemove) {
		int location = search(numToRemove);
		if(location != -1) {
			for(int i = location; i < count-1; i++) {
				list[i] = list[i+1];
			}
			if(count == list.length) {
				list[list.length-1] = 0;
			}
			//determine how much room is left in list
			int emptySpaces = 0;
			for(int i = 0; i < list.length; i++) {
				if(list[i] == 0) emptySpaces++;
			}
			//decrease size if > 25% is left
			if(emptySpaces > (list.length+1)/4) {
				int[] newList = new int[(list.length*3)/4];
				for(int i = 0; i < newList.length; i++) {
					newList[i] = list[i];
				}
				list = newList;
				newList = null;
			}
			count--;
		}
		
	}
	
	/**
	 * Fetches the length of the list
	 * @return length of list, range 0-10
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Returns the int list in String format, ie "1 2 3" for list containing [1,2,3]
	 * @return String version of list, ie "1 2 3" for list containing [1,2,3]
	 *			<p>"" if null
	 */
	public String toString() {
		String returnedString = "";
		for(int i = 0; i < count-1; i++) {
			returnedString = returnedString + list[i] + " ";
		}
		returnedString = returnedString + list[count-1];
		return returnedString;
	}
	
	/**
	 * Searches for a given number in the list
	 * @param numToSearch Number to search for
	 * @return First index or -1 if not found
	 */
	public int search(int numToSearch) {
		int location = -1;
		for(int i = count-1; i >= 0; i--) {
			if(list[i] == numToSearch) {
				location = i;
			}
		}
		return location;
	}
	
	/**
	 * Add a number to the end of the list
	 * Extends list by 50% if there is not enough room
	 * @param numToAdd Number to add
	 */
	public void append(int numToAdd) {
		//If list is full, extend by 50% to make room
		if(count == list.length) {
			int[] newList = new int[(count/2)*3];
			for( int i = 0; i < count; i++) {
				newList[i] = list[i];
			}
			//set list to newList and reclaim memory
			list = newList;
			newList = null;
		}
		list[count] = numToAdd;
		count++;
	}
	
	/**
	 * Returns the first number of the list
	 * @return Number at first index or -1 if not found
	 */
	public int first() {
		int ret = -1;
		if(count != 0) {
			ret = list[0];
		}
		return ret;
	}
	
	/**
	 * Returns the current possible size of the list
	 * @return Max size of list
	 */
	public int size() {
		return list.length;
	}
}

