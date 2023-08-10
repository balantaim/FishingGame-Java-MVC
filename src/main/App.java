package main;


import controller.FishingGameController;
import view.FishingGame;


public class App {
	
	private static FishingGame view;
	private static FishingGameController controller;

	public static void main(String[] args) {

		view = new FishingGame();
		controller = new FishingGameController(view);
		controller.startGame();
	}

}
