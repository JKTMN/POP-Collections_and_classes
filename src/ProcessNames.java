import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ProcessNames {

	/** readNames()
	 * creates an empty array list, and reads names from a file adding them to the array list
	 *
	 * @param myNames the file to read from
	 * @return the array list storing the name
	 * @throws FileNotFoundException throws file not found errors
	 */
	public ArrayList<String> readNames(String myNames) throws FileNotFoundException{
		ArrayList<String> names = new ArrayList<>(20); //creates empty array list
		Scanner reader = new Scanner(new File(myNames));	//reader to read from file
		while (reader.hasNext()) {	//while loop that runs while the file has next value
			names.add(reader.nextLine());	//adds names to the array list
		}

		return names;	//returns the array list
	}


	/** sortNames()
	 * sorts the names from the previous array list into alphabetical order and returns it
	 *
	 * @param myNames the array list storing the names
	 * @return the sorted array list
	 */
	public ArrayList<String> sortNames(ArrayList<String> myNames){
		Collections.sort(myNames);		//sorts the array list
		return myNames;		//returns the sorted array list
	}


	/** findNamePosition()
	 * this searches through the array list for an inputted name using a while loop to confirm if the name has been found,
	 * inside is an if statement that runs throgh different indexes and sets the index of the name found to a variable.
	 * if it found the name it sets a boolean to true which stops the while loop from running, if it doesn't find
	 * the name it switches to an else statement that increments the index value. returns -1 if the name cannot be found.
	 *
	 * @param myNames the array list storing the name
	 * @param name the name to find
	 * @return the index of the name
	 */
	public int findNamePosition(ArrayList<String> myNames, String name) {
		int index = 0;		//index variable set to 0
		boolean found = false;	//boolean variable set to false
		int indexOfName = -1;	//index of name which is set to -1
		while (!found && index < myNames.size()){	//while loop that runs while the boolean is false the index is less
			// than the arraylist size
			if (myNames.get(index).equals(name)){	//if loop that compares the two names
				indexOfName = index;	//sets the index location variable to the index
				found = true;	//sets the boolean to true

			} else{
				index++;	//increments the index variable if it didn't find the name
			}
		}
		return indexOfName;	//returns the index of the name
	}


	/** deleteName()
	 * a name is inputted and then that name is removed from the array list
	 *
	 * @param myNames array list storing the names
	 * @param name the name to remove
	 * @return the updated array list
	 */
	public ArrayList<String> deleteName(ArrayList<String> myNames, String name){
		myNames.remove(name);	//removes the name from the array list
		return myNames;
	}


	/** changeName()
	 * takes two name inputs, the first the name to replace, and the second to replace it with.
	 * A variable is created which stores the index value of the first name, it then adds the new name by
	 * replacing the index value of the first name. it then returns the updated array list.
	 *
	 * @param myNames array list storing names
	 * @param name1 the name to be replaces
	 * @param name2 the new name
	 * @return the updated array list
	 */
	public ArrayList<String> changeName(ArrayList<String > myNames, String name1, String name2){
		int replace = myNames.indexOf(name1);		//variable containing the index of the first name
		myNames.add(replace, name2);		//replacing the indexes name with the new name
		return myNames;	//returning updated array list
	}


}