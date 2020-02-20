package campos_problem1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI5 {

	private static double score;
	private static double correctCount = 0.0;
	private static int introDone = 0;
	private static int randomCheck;
	private static int resetChoice;
	private static int mathType;
	private static int difficulty;
	private static int count;
	private static int intOne;
	private static int intTwo;
	private static int userAnswer;
	private static int answer;
	private static int switchInt;
	
	private static void generateSwitchRandom() {
		Random rand = new Random(); 
		
		 switchInt = rand.nextInt(3); 
	}
	
	private static void generateQuestionArgument() {
		SecureRandom rand = new SecureRandom();
		
		if(difficulty == 1)
		{
        intOne = rand.nextInt(10); 
        intTwo = rand.nextInt(10); 
		}
		
		if(difficulty == 2)
		{
        intOne = rand.nextInt(100); 
        intTwo = rand.nextInt(100); 
		}
		
		if(difficulty == 3)
		{
        intOne = rand.nextInt(1000); 
        intTwo = rand.nextInt(1000); 
		}
		
		if(difficulty == 4)
		{
        intOne = rand.nextInt(10000); 
        intTwo = rand.nextInt(10000); 
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
		if(userAnswer == answer)
		{
			displayCorrectResponse();
		}
		
		if(userAnswer != answer)
		{
			displayIncorrectResponse();
		}
		
	}
	
	private void readResponse() {
		Scanner in = new Scanner(System.in);
		userAnswer = in.nextInt();
	}
	
	private static void setAnswer() {
		
		if(mathType == 1)
		{
		answer = intOne + intTwo;
		}
		
		else if(mathType == 2)
		{
		answer = intOne * intTwo;
		}
		
		else if(mathType == 3)
		{
		answer = intOne - intTwo;
		}
		
		else if(mathType == 4)
		{
		answer = intOne / intTwo;
		}
		
	}
	
	private static void askQuestion() {
		if(mathType == 1)
		{
		System.out.println("How much is " + intOne + " PLUS " + intTwo +"?");
		}
		
		else if(mathType == 2)
		{
		System.out.println("How much is " + intOne + " TIMES " + intTwo +"?");
		}
		
		else if(mathType == 3)
		{
		System.out.println("How much is " + intOne + " MINUS " + intTwo +"?");
		}
		
		else if(mathType == 4)
		{
		System.out.println("How much is " + intOne + " DIVIDED BY " + intTwo +"?");
		}
		
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
	
	private static void askDifficulty() {
		System.out.println("Please select a difficulty level");
		System.out.println("1 - Single Digits");
		System.out.println("2 - Double Digits");
		System.out.println("3 - Triple Digits");
		System.out.println("4 - Quadruple Digits");
		
		readDifficulty();
	}
	
	private static void readDifficulty() {
		Scanner in = new Scanner(System.in);
		difficulty = in.nextInt();
		
		
	}
	
	private static void askReset() {
		System.out.println("Would you like to attempt another set of numbers?");
		System.out.println("1 = Yes     2 = No");
		userReset();
	}
	
	private static void userReset() {
		Scanner in = new Scanner(System.in);
		resetChoice = in.nextInt();
		
		if(resetChoice == 1) 
		{
			resetYes();
		}
		
		if(resetChoice == 2) 
		{
			resetNo();
		}
		
	}
	
	private static void resetYes() {
		count = -1;
		correctCount = 0;
		introDone = 0;
		randomCheck = 0;
		return;
	}
	
	private static void resetNo() {
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
	private static void askProblemType() {
		System.out.println("Please select an arithmatic type");
		System.out.println("1 - Addition");
		System.out.println("2 - Multiplication");
		System.out.println("3 - Subtraction");
		System.out.println("4 - Division");
		System.out.println("5 - All Arithmatic Options");
		
		readProblemType();
	}
	
	private static void readProblemType() {
		Scanner in = new Scanner(System.in);
		mathType = in.nextInt();
		
		if(mathType == 5)
		{
			randomCheck = 1;
		}
	}
	
	private static void randomMathType(){
		Random rand = new Random();
		
		mathType = rand.nextInt(4) + 1; 
	}
	
	public void quiz() {
		for(count = 0; count < 10; count++)
		{
			if(introDone != 1)
			{
			askDifficulty();
			askProblemType();
			introDone = 1;
			}
		
			if(randomCheck == 1)
			{
				randomMathType();
			}
			
		generateQuestionArgument();
		setAnswer();
		askQuestion();
		readResponse();
		isAnswerCorrect();
		if(count == 9)
			{
			displayCompletionMessage();
			askReset();
			}
		}

	}
	
	public static void main(String args[]) {
		CAI5 app = new CAI5();
		app.quiz();
	}
	
	
}

