package cristiano.dewes.jogoforca.utils;

import java.util.Random;

public class RandomUtils {
	
	private static Random random = new Random();
	
	public static int newRandomNumber(int min, int max) {
		return min + random.nextInt(max - min);
	}
}
