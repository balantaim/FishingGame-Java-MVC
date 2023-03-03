package objects;

import java.util.ArrayList;
import java.util.Random;

import values.Fish;

public class Pond extends Place {

	private ArrayList<String> fishList = new ArrayList<>();

	public void getFishes() {
		Random rn = new Random();
		int number = rn.nextInt(14);
		System.out.println("\nThis is your fish list!\n");

		for (int i = 0; i < number; i++) {
			fishList.add(Fish.values()[i].toString());
			System.out.println(i + 1 + " " + Fish.values()[i]);
		}
	}

	public boolean lostFish(String name) {
//		Random rn = new Random();
//		int number = rn.nextInt(14);

		if (fishList.contains(name)) {
			fishList.remove(name);
			System.out.println(name + " is removed");
			return true;
		}
		System.out.println(name + " is not in the list");
		return false;
	}

	public String obtainFish() {
		Random rn = new Random();
		int number = rn.nextInt(14);

		return Fish.values()[number].toString();
	}

	public boolean checkExist(String name) {
		return fishList.contains(name);
	}

	public void showState() {
		final String poor = "poor", rich = "rich", normal = "normal";
		String s = "";
		if (fishList.size() < 5) {
			s = poor;
		} else if (fishList.size() < 11 && fishList.size() >= 5) {
			s = normal;
		} else {
			s = rich;
		}
		System.out.println("The pond is " + s);
	}
}
