package controller;

import model.Model;
import view.FishingGame;

public class FishingGameController {
	
	private FishingGame view;
	private Model model;
	

	public FishingGameController(FishingGame view, Model model) {
		this.view = view;
		this.model = model;
		
	}
	
	public void startGame() {
		view.initGame();
	}

}
