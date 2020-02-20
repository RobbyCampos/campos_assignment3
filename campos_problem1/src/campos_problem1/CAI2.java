package campos_problem1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI2 {

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
	
	private void incorrectLoop(){
		readResponse();
		if(userAnswer != product)
		{
			displayIncorrectResponse();
		}
		
		else
		{
			displayCorrectResponse();
		}
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
		incorrectLoop();
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
	
	private static void setProduct() {
		product = intOne * intTwo;
	}
	
	private int getProduct() {
		return product;
	}
	
	private static void askQuestion() {
		System.out.println("How much is " + intOne + " times " + intTwo +"?");
	}
	
	public void quiz() {
		generateRandom();
		setProduct();
		askQuestion();
		readResponse();
		isAnswerCorrect();
	}
	
	public static void main(String args[]) {
		CAI2 app = new CAI2();
		app.quiz();
	}
	
	
}
