package view;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

import objects.Pond;
import tools.GameSaver;


public final class FishingGame {

	private static MessageManager print;
	private static Pond pond;
	private static GameSaver logger;
	private static int count = 6;
	private static String userInput = "", userSelector = "", userName = "";
	private static Scanner sc;

	public void initGame() {
		print = new MessageManager();
		pond = new Pond();
		sc = new Scanner(System.in);
		logger = new GameSaver();

//		String rand = UUID.randomUUID().toString();
//		System.out.println(rand);
		print.run();
		primaryMenu();
		
		sc.close();
	}

	public static void newGame() {
		while (userSelector.length() < 3) {
			print.whatIsYourName();
			userSelector = sc.nextLine();
			if (userSelector.length() >= 3 && userSelector.length() < 150) {
				userName = userSelector;
			}
		}
		gameOptions();
	}
	private static void gameOptions() {
		System.out.println("Your try counter is: " + count);
		if(count>0) {
			print.gameOptions();
			userInput = sc.nextLine();
			switch (userInput) {
				case "1" -> {pond.getFishes(); count--; retryCounterGameMenu();}
				case "2" -> {pond.lostFish("Shark"); retryCounterGameMenu();}
				case "3" -> {pond.showState(); retryCounterGameMenu();}
				case "4" -> retryCounter();

				default -> retryCounterGameMenu();
			}
		}else{
			logger.CreateLog(userName, pond.returnTotalScore());
			print.gameOver();
		}
	}
	public static void primaryMenu() {
		print.mainMenu();
		userInput = sc.nextLine();
		
		switch (userInput) {
			case "1" -> newGame();
			case "2" -> { print.legend(); retryCounter(); }
			case "3" -> {
				try {System.out.println(logger.ReadLog());
				} catch (IOException e) {
					e.printStackTrace();
				}
				retryCounter();}
			case "4" -> {
				count = 0;
				print.bye(userName);
			}

			default -> retryCounter();
		}
		
	}
	private static void retryCounter() {
		if(count>0) {
			primaryMenu();
		}
	}
	private static void retryCounterGameMenu() {
		if(count>0) {
			gameOptions();
		} else {
			logger.CreateLog(userName, pond.returnTotalScore());
			print.gameOver();
		}
	}
	
	
	
	
}
