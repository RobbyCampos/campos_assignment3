package campos_problem1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI3 {

	private static double score;
	private static double correctCount = 0.0;
	private static int count;
	private static int intOne;
	private static int intTwo;
	private static int userAnswer;
	private static int product;
	private static int switchInt;
	
	private static void generateSwitchRandom() {
		Random rand = new Random(); 
		
		 switchInt = rand.nextInt(3); 
	}
	
	private static void generateRandom () {
		SecureRandom rand = new SecureRandom();
		
        intOne = rand.nextInt(10); 
        intTwo = rand.nextInt(10); 
	}
	
	private void displayIncorrectResponse() {
		generateSwitchRandom();
		switch(switchInt)
			{
			case 0: System.out.println("No. Please try again.");
			break;
			
			case 1: System.out.println("Wrong. Try once more.");
			break;
			
			case 2: System.out.println("Dont give up!");
			break;
			
			case 3: System.out.println("No. Keep Trying.");
			break;
			}
	}
	
	private void displayCorrectResponse() {
		generateSwitchRandom();
		switch(switchInt)
			{
			case 0: System.out.println("Very Good!");
			break;
			
			case 1: System.out.println("Excellenct!");
			break;
			
			case 2: System.out.println("Nice Work!");
			break;
			
			case 3: System.out.println("Keep Up The Good Work!");
			break;
			}
		
		correctCount++;
		
		}
		
	
	private void isAnswerCorrect() {
		if(userAnswer == product)
		{
			displayCorrectResponse();
		}
		
		if(userAnswer != product)
		{
			displayIncorrectResponse();
		}
		
	}
	
	private void readResponse() {
		Scanner in = new Scanner(System.in);
		userAnswer = in.nextInt();
	}
	
	private int getUserAnswer() {
		return userAnswer;
	}
	
	
	private static void setProduct() {
		product = intOne * intTwo;
	}
	
	private int getProduct() {
		return product;
	}
	
	private static void askQuestion() {
		System.out.println("How much is " + intOne + " times " + intTwo +"?");
	}
	
	private static void calculateScore() {
		score = 100 * (correctCount / 10);
		score = Math.round(score);
	}
	
	private static void displayScore(){
		calculateScore();
		System.out.println("\nYou scored a " + score +"%");

	}
	
	private static void displayCompletionMessage() {
		displayScore();
		if(score > 70)
		{
			System.out.println("\nCongratulations, you are ready to go to the next level!\n\n");
		}
		
		else 
		{
			System.out.println("\nPlease ask your teacher for extra help.\n\n");
		}
	}
	
	public void quiz() {
		for(count = 0; count < 10; count++)
		{
		generateRandom();
		setProduct();
		askQuestion();
		readResponse();
		isAnswerCorrect();
		if(count == 9)
			{
			displayCompletionMessage();
			count = -1;
			correctCount = 0;
			}
		}
	}
	
	public static void main(String args[]) {
		CAI3 app = new CAI3();
		app.quiz();
	}
	
	
}
