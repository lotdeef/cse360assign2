/**
 * @author London Fischer
 * Class ID: 379
 * Assignment #1
 * 
 * This Class creates an integer list holding up to 10 integers.
 * It contains private variables int[10] list and int count.
 * The available public methods are: add, remove, count, toString, and search
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
	 * Add a number to the bottom of the list
	 * @param numToAdd Number to add
	 */
	public void add(int numToAdd) {
		for(int i = 9; i > 0; i--) {
			list[i] = list[i-1];
		}
		list[0] = numToAdd;
		if(count < 10) {
			count++;
		}
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
			if(count == 10) {
				list[9] = 0;
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
}
