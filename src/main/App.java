package main;


import controller.FishingGameController;
import model.Model;
import view.FishingGame;


public class App {
	
	private static FishingGame view;
	private static Model model;
	private static FishingGameController controller;

	public static void main(String[] args) {

		view = new FishingGame();
		model = new Model();
		controller = new FishingGameController(view, model);
		controller.startGame();
			
	}

}
