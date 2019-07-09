package etudes;

import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
		return s.chars().mapToObj(c -> (char)c).collect(toSet());
	}
	
	/**
	 * Find which character is most frequently encountered in a string.
	 */
	public static Character mostFrequentChar(String s) {
		Map<Character, Integer> freqMap = new HashMap<>();
		s.chars().forEach(ch -> {
			freqMap.merge((char)ch, 1, Integer::sum);
		});
		return freqMap.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
	}
}
