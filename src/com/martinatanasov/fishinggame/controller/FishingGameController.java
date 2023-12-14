package com.martinatanasov.fishinggame.controller;

import java.io.IOException;

import com.martinatanasov.fishinggame.data.Repository;
import com.martinatanasov.fishinggame.view.FishingGame;

public class FishingGameController {
	
	private FishingGame view;
	private static Repository repository;
	
	public FishingGameController(FishingGame view) {
		this.view = view;
		repository = new Repository();
	}
	
	public void startGame() {
		view.initGame();
	}
	
	public void makeNewRecord(String name, int score) {
		repository.save(name, score);
	}
	
	public String readTheRecords() throws IOException {
		return repository.load();
	}

}
