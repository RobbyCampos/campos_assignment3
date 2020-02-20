package campos_problem1;

import java.security.SecureRandom;
import java.util.Random; 
import java.util.Scanner;

public class CAI1 {
	
	private static int intOne;
	private static int intTwo;
	private static int userAnswer;
	private static int product;
	
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
		System.out.println("No, Please Try Again");
		incorrectLoop();
	}
	
	private void displayCorrectResponse() {
		System.out.println("Very Good!");
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
		CAI1 app = new CAI1();
		app.quiz();
	}
	
	
}
