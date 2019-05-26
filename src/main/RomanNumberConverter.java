package main;

import java.util.HashMap;

import com.sun.tools.javac.util.Pair;

public class RomanNumberConverter {

	private static final char ROMAN_100 = 'C';
	private static final char ROMAN_50 = 'L';
	private static final char ROMAN_10 = 'X';
	private static final char ROMAN_1 = 'I';
	private static final char ROMAN_5 = 'V';
	private final HashMap<Pair<Character, Character>, Integer> romanRules;

	public RomanNumberConverter() {
		romanRules = new HashMap<>();
		romanRules.put(new Pair<>(ROMAN_1, ROMAN_5), 3);
		romanRules.put(new Pair<>(ROMAN_1, ROMAN_10), 8);
		romanRules.put(new Pair<>(ROMAN_10, ROMAN_50), 30);
		romanRules.put(new Pair<>(ROMAN_10, ROMAN_100), 80);
	}

	public int convert(String numberString) {
		int result = 0;
		char lastCharacter = ' ';
		for (int j = 0; j < numberString.length(); j++) {
			char currentCharacter = numberString.charAt(j);

			result = sumThisCharacterDependingOnLastCharacter(currentCharacter, lastCharacter, result);
			lastCharacter = currentCharacter;
		}

		return result;
	}

	private int sumThisCharacterDependingOnLastCharacter(char currentCharacter, char lastCharacter, int sum) {
		Integer result = romanRules.get(new Pair<>(lastCharacter, currentCharacter));
		if (result == null) {
			result = chatConvert(currentCharacter);
		}

		return sum + result;
	}

	private Integer chatConvert(char currentCharacter) {
		switch (currentCharacter) {
		case ROMAN_1:
			return 1;
		case ROMAN_5:
			return 5;
		case ROMAN_10:
			return 10;
		case ROMAN_50:
			return 10;
		case ROMAN_100:
			return 100;
		default:
			return 0;
		}

	}

}
