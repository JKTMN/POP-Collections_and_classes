import java.util.Scanner;

public class Craps {
    Dice dice1 = new Dice();	//creating new dice objects
	Dice dice2 = new Dice();

	/** shoot()
	 * uses the roll method on the dice objects
	 */
	public void shoot() {
		dice1.roll();	//rolls the first dice object
		dice2.roll();	//rolls the second dice object
	}

	/** getDice1()
	 * returns the first dice roll
	 *
	 * @return dice 1
	 */
	public Dice getDice1() {
		return dice1;	//returns dice 1
	}


	/** getDice2()
	 * returns the second dice roll
	 *
	 * @return dice 2
	 */
	public Dice getDice2() {
		return dice2;	//returns dice 2
	}


	/** addUpScore()
	 * uses the getFaceValue method on the dice and returns the sum of them
	 *
	 * @return the sum of the two dice
	 */
	public int addUpScore() {
		return dice1.getFaceValue() + dice2.getFaceValue();	//adds the two values of the dice together
	}

	/** decideOutcome()
	 * compares the score to pre-determined numbers using if else if statements and changes a variable
	 * to have a different message based on the score, it has a win, a lose and throw again message.
	 *
	 * @param score the sum of the two dice
	 * @return the outcome of the game
	 */
	String outcome;	//empty variable for the output message
	public String decideOutcome(int score) {
		if(score == 7 || score == 11){	//compares the score to the winning numbers
            outcome = "You Win";	//sets the winning message
        }
        else if (score == 2 || score == 3 || score == 12){	//compares the score to the losing numbers
            outcome = "You Lose";	//sets the losing message
        }
        else{	//else statement that runs for all the other numbers
            outcome = "Throw again";	//sets the throw again message
        }
        return outcome;	//returns the outcome of the game
	}


	/** getResults()
	 * prints the results from the dice, the score total and the outcome on separate lines
	 *
	 * @return the values
	 */
	public String getResults() {
		System.out.println("Dice 1 is " + dice1);	//setting the dice string to be printed
		System.out.println("Dice 2 is " + dice2);	//setting the dice string to be printed
		System.out.println("Total is " + addUpScore());	//setting the score string to be printed
		System.out.println("Result is " + outcome);	//setting the outcome string to be printed
		return "                       ";	//returns a blank line to keep it organised and easier to read
	}


	/** playCraps()
	 * sets a boolean to true while the outcome is throw again, while it is true a while loop runs
	 * that plays the game again until the outcome is something different
	 *
	 * @return the results
	 */
	public String playCraps() {
		String results = "";
		boolean playAgain = outcome.equals("Throw again");	//sets the boolean to the outcomes value,
		while (playAgain){ //while the booleean is true the loop runs
			shoot();	//calls the shoot method to roll the dice again
			decideOutcome(addUpScore());	//calls decide outcome method to decide the outcome of the dice
			results = getResults();	//puts the get results method into a variable
			playAgain = outcome.equals("Throw again"); //checks to see if the boolean is still true if not sets to false
		}
		return results;	//return results
	}


	/** playAgain()
	 * asks the user if they would like to play again using a keyboard scanner, if they answer Y or Yes,
	 * the game starts again, after it is played through it asks if they would like to pkay again until they say N or No
	 * otherwise it asks again
	 */
	public void playAgain(){
		Scanner keyboard = new Scanner(System.in);		//creates keyboard scanner
		System.out.println("Would you like to play again? ");	//asks if they would like to play again
		String playAgain = keyboard.next();	//sets keyboard input to variable
		if (playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("YES")){
			//if loop thst checks if variable is equal to yes
			shoot();	//calls the shoot method to roll the dice again
			decideOutcome(addUpScore());	//calls decide outcome method to decide the outcome of the dice
			System.out.println(getResults());	//prints the results of the turn
			playCraps();		//calls the craps method to see if it needs to be thrown again
			playAgain();	//calls play again method to see if they want to play again
		} else if (playAgain.equalsIgnoreCase("N") || playAgain.equalsIgnoreCase("NO")) {
			//else if that checks if user input is no
			keyboard.close();	//closes keyboard if they inputted no, stopping the program
		} else {	//else statement that runs if anything else is inputted
			playAgain();	//calls play again method to ask if they want to play again
		}
	}
}
