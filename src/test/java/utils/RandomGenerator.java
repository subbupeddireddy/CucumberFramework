package utils;

import java.util.Random;

import org.testng.annotations.Test;

public class RandomGenerator {

	@Test
	public String randomNumber(int number) {

		number -=2;

		String num = "0123456789";

		StringBuilder ab = new StringBuilder();
		Random random = new Random();

		for (int q = 0; q < number; q++) {

			ab.append(num.charAt(random.nextInt(num.length())));
		}

		return "04" + String.valueOf(ab);

	}

	@Test
	public void randomString(int num) {
		String charc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Random ran = new Random();

		StringBuilder ab = new StringBuilder();
		for (int q = 0; q < num; q++) {
			ab.append(charc.charAt(ran.nextInt(charc.length())));
		}
		System.out.println("subbu --->" + ab);

	}

}
