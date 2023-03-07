package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GameSaver {
	
	public void CreateLog(String name, int score) {
		try {
			FileWriter fw = new FileWriter("src\\model\\SaveLog.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("\tName: " + name + " Score: " + score);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String ReadLog() throws IOException {
		String result = "";
		BufferedReader br = new BufferedReader(new FileReader("src\\model\\SaveLog.txt"));
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
