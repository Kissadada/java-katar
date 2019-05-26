package main;

import java.util.ArrayList;

public class StringCalculator {

	private static final String DIGIT_LIST = "0123456789";

	public int add(String inputString) {
		ArrayList<String> stringNumberList = filterJustStringNumber(inputString);

		if ("".equals(inputString)) {
			return 0;
		}
		return sumOfNumberList(stringNumberList);
	}

	private ArrayList<String> filterJustStringNumber(String inputString) {
		ArrayList<String> numberArrayList = new ArrayList<>();
		for (int i = 0; i < inputString.length(); i++) {
			String c = String.valueOf(inputString.charAt(i));
			if (DIGIT_LIST.contains(c)) {
				numberArrayList.add(c);
			}
		}
		return numberArrayList;
	}

	private int sumOfNumberList(ArrayList<String> stringNumberList) {
		int sum = 0;
		for (String stringNumber : stringNumberList) {
			sum += Integer.parseInt(stringNumber);
		}
		return sum;
	}
}
