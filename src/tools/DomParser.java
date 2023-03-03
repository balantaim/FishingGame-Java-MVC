package tools;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {

	public static String appName = "", welcome = "", newFish = "", loseFish = "", gameOver = "", menu="",yourName="",bye="",legend="",gameOptions="";

	public synchronized void init() {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse("src\\values\\strings.xml");
			NodeList stringList = document.getElementsByTagName("string");
			for (int i = 0; i < stringList.getLength(); i++) {
				Node myNode = stringList.item(i);
				if (myNode.getNodeType() == Node.ELEMENT_NODE) {
					Element stringElement = (Element) myNode;
					String id = stringElement.getAttribute("name");

					switch (id) {
						case "app_name" -> appName = stringElement.getTextContent();
						case "welcome" -> welcome = stringElement.getTextContent();
						case "new_fish" -> newFish = stringElement.getTextContent();
						case "lose_fish" -> loseFish = stringElement.getTextContent();
						case "game_over" -> gameOver = stringElement.getTextContent();
						case "menu" -> menu = stringElement.getTextContent();
						case "your_name" -> yourName = stringElement.getTextContent();
						case "bye" -> bye = stringElement.getTextContent();
						case "legend" -> legend = stringElement.getTextContent();
						case "game_options" -> gameOptions = stringElement.getTextContent();
						
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
