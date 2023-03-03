package tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GameSaver {
	public static void CreateLog(String name, int score) {
		try {
			FileWriter fw = new FileWriter("src\\model\\SaveLog.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("\tName: " + name + " Score: " + score);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
