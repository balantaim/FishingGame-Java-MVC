package objects;

import java.util.ArrayList;
import java.util.Random;

import values.Fish;



public class Pond extends Place {

	private ArrayList<String> fishList = new ArrayList<>();
	private int score = 0;

	public void getFishes() {
		Random rn = new Random();
		int number = rn.nextInt(14);
		System.out.println("\nThis is your fish list!\n");

		for (int i = 0; i < number; i++) {
			fishList.add(Fish.values()[i].toString());
			score += (rn.nextInt(5)) * 100;
			System.out.println(i + 1 + " " + Fish.values()[i]);
		}
		System.out.println("Score " + score);
		
	}
	
	public boolean getExtraFish() {
		Random rn = new Random();
		final int num = rn.nextInt(2); 
		if(num == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean lostFish(String name) {
		Random rn = new Random();

		if (fishList.contains(name)) {
			fishList.remove(name);
			score = score - ((rn.nextInt(5) * 100));
			score = score > 0 ? score:0;
			System.out.println(name + " is removed");
			System.out.println("Your score is: " + score);
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
	
	public int returnTotalScore() {
		return score;
	}
}
