package etudes;

import java.util.HashSet;
import java.util.Set;

public class Strings {
	
	/**
	 * Test if two strings have the same set of chars.
	 */
	public static boolean haveMatchingChars(String s1, String s2) {
		Set<Character> set1 = toSetOfChars(s1);
		Set<Character> set2 = toSetOfChars(s2);
		if (set1.size() != set2.size()) {
			return false;
		}
		for (Character c : set1) {
			if (!set2.contains(c)) {
				return false;
			}
		}
		return true;
	}
	
	private static Set<Character> toSetOfChars(String s) {
		Set<Character> chars = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			chars.add(s.charAt(i));
		}
		return chars;
	}
}
