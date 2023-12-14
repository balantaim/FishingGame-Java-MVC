package com.martinatanasov.fishinggame;

import com.martinatanasov.fishinggame.controller.FishingGameController;
import com.martinatanasov.fishinggame.view.FishingGame;


public class Application {
	
	private static FishingGame view;
	private static FishingGameController controller;

	public static void main(String[] args) {

		view = new FishingGame();
		controller = new FishingGameController(view);
		controller.startGame();
	}

}
