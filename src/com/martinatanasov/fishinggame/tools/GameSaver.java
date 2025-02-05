package com.martinatanasov.fishinggame.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GameSaver {
	
	private final static String LOG_DIRECTORY = "src/com/martinatanasov/fishinggame/data/";
	private final static String LOG_FILE = LOG_DIRECTORY + "SaveLog.txt";
	
	public void CreateLog(String id, String name, int score) {
		try {
			FileWriter fw = new FileWriter(LOG_FILE, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("\tID: " + id + ", Name: " + name + ", Score: " + score);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String ReadLog() throws IOException {
		String result = "";
		BufferedReader br = new BufferedReader(new FileReader(LOG_FILE));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    result = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    br.close();
		}
		return result;
	}
	
}
