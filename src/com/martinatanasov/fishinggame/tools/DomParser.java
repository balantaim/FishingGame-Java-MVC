package com.martinatanasov.fishinggame.tools;

import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {

	private final static String VALUES_DIRECTORY = "src/com/martinatanasov/fishinggame/values/";
	private final static String VALUES_FILE = VALUES_DIRECTORY + "strings.xml";
	public static HashMap<String, String> stringResource = new HashMap<>();

	public synchronized void init() {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(VALUES_FILE);
			NodeList stringList = document.getElementsByTagName("string");
			for (int i = 0; i < stringList.getLength(); i++) {
				Node myNode = stringList.item(i);
				if (myNode.getNodeType() == Node.ELEMENT_NODE) {
					Element stringElement = (Element) myNode;
					String id = stringElement.getAttribute("name");

					switch (id) {
						case "app_name" -> stringResource.put( "appName", stringElement.getTextContent());
						case "welcome" -> stringResource.put( "welcome", stringElement.getTextContent());
						case "new_fish" -> stringResource.put( "newFish", stringElement.getTextContent());
						case "lose_fish" -> stringResource.put( "loseFish", stringElement.getTextContent());
						case "game_over" -> stringResource.put( "gameOver", stringElement.getTextContent());
						case "menu" -> stringResource.put( "menu", stringElement.getTextContent());
						case "your_name" -> stringResource.put( "yourName", stringElement.getTextContent());
						case "bye" -> stringResource.put( "bye", stringElement.getTextContent());
						case "legend" -> stringResource.put( "legend", stringElement.getTextContent());
						case "game_options" -> stringResource.put( "gameOptions", stringElement.getTextContent());
						//case "game_options" -> gameOptions = stringElement.getTextContent();
						
						default -> throw new IllegalStateException("Invalid data: " + id);
					}
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
