package com.martinatanasov.fishinggame.view;


import com.martinatanasov.fishinggame.tools.DomParser;
import com.martinatanasov.fishinggame.values.Colors;

public class MessageManager {
	
	DomParser collectData;

	public void run() {
		collectData = new DomParser();
		collectData.init();

		System.out.println(Colors.ANSI_CYAN.value() + DomParser.stringResource.get("appName") + "\n" + DomParser.stringResource.get("welcome") + "\n" + Colors.ANSI_RESET.value());
	}

	public void mainMenu() {
		System.out.println(Colors.ANSI_YELLOW.value() + "\t\t" + DomParser.stringResource.get("menu") + Colors.ANSI_RESET.value());
	}

	public void whatIsYourName() {
		System.out.println(Colors.ANSI_RED.value() + DomParser.stringResource.get("yourName") + Colors.ANSI_RESET.value());
	}

	public void bye(String name) {
		System.out.println(Colors.ANSI_CYAN.value() + DomParser.stringResource.get("bye") + " " + name + "!" + Colors.ANSI_RESET.value());
	}

	public void legend() {
		System.out.println(Colors.ANSI_GREEN.value() + DomParser.stringResource.get("legend") + "\n" + Colors.ANSI_RESET.value());
	}

	public void gameOptions() {
		System.out.println(Colors.ANSI_YELLOW.value() + DomParser.stringResource.get("gameOptions") + Colors.ANSI_RESET.value());
	}

	public void gameOver() {
		System.out.println(Colors.ANSI_RED.value() + "\n" + DomParser.stringResource.get("gameOver") + Colors.ANSI_RESET.value());
	}
}
