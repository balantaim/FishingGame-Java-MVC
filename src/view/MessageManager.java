package view;


import tools.DomParser;
import values.Colors;

public class MessageManager {
	
	DomParser collectData;

	public void run() {
		collectData = new DomParser();
		collectData.init();

		System.out.println(Colors.ANSI_CYAN.value() + DomParser.appName + "\n" + DomParser.welcome + "\n" + Colors.ANSI_RESET.value());
	}

	public void mainMenu() {
		System.out.println(Colors.ANSI_YELLOW.value() + "\t\t" + DomParser.menu + Colors.ANSI_RESET.value());
	}

	public void whatIsYourName() {
		System.out.println(Colors.ANSI_RED.value() + DomParser.yourName + Colors.ANSI_RESET.value());
	}

	public void bye(String name) {
		System.out.println(Colors.ANSI_CYAN.value() + DomParser.bye + " " + name + "!" + Colors.ANSI_RESET.value());
	}

	public void legend() {
		System.out.println(Colors.ANSI_GREEN.value() + DomParser.legend + Colors.ANSI_RESET.value());
	}

	public void gameOptions() {
		System.out.println(Colors.ANSI_YELLOW.value() + DomParser.gameOptions + Colors.ANSI_RESET.value());
	}

	public void gameOver() {
		System.out.println(Colors.ANSI_RED.value() + "\n" + DomParser.gameOver + Colors.ANSI_RESET.value());
	}
}
