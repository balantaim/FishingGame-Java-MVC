package com.martinatanasov.fishinggame.data;

import java.io.IOException;
import java.util.UUID;

import com.martinatanasov.fishinggame.entity.Player;
import com.martinatanasov.fishinggame.tools.GameSaver;

public class Repository {
	private static GameSaver logger;
	
	public Repository() {
		logger = new GameSaver();
	}
	
	public void save(String name, int score) {
		Player player = new Player(
				UUID.randomUUID().toString(),
				name,
				score
				);
		logger.CreateLog(player.getId(), player.getName(), player.getScore());
		
	}
	public String load() throws IOException {
		return logger.ReadLog();
	}
	
}