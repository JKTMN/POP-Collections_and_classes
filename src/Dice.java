import java.util.Random;

public class Dice {
    private int faceValue = 0;	//global variable set to 0

	/** roll()
	 * generates a random number between 1-6 and sets it to the global variable
	 * which was declared before
	 */
	public void roll() {
        Random roll = new Random();	//random number generator
		faceValue = roll.nextInt(6) + 1;	//generating number into the variable
	}


	/** getFaceValue()
	 * returns the facevalue variable
	 *
	 * @return the facevalue
	 */
	public int getFaceValue() {
		return faceValue;	//returns facevalue
	}


	/** toString()
	 * converts the facevalue value to a string and returns it
	 *
	 * @return the string value of facevalue
	 */
	public String toString() {
		return String.valueOf(faceValue);	//returns the string value of face value
	}


}
