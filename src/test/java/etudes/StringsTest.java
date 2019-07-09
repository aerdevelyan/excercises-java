package etudes;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringsTest {

	@Test
	public void charMatcherPositive() {
		String s1 = "abcdd";
		String s2 = "cabd";
		assertTrue(Strings.haveMatchingChars(s1, s2));
		assertTrue(Strings.haveMatchingChars(s2, s1));
		s1 = "ccabbbdddd";
		s2 = "aaaacdbbbbbb";
		assertTrue(Strings.haveMatchingChars(s1, s2));
		assertTrue(Strings.haveMatchingChars(s2, s1));
	}
	
	@Test
	public void charMatcherNegative() {
		String s1 = "badd";
		String s2 = "cdbdf";
		assertFalse(Strings.haveMatchingChars(s1, s2));
		assertFalse(Strings.haveMatchingChars(s2, s1));
		s1 = "dabg";
		s2 = "dabgf";
		assertFalse(Strings.haveMatchingChars(s1, s2));
		assertFalse(Strings.haveMatchingChars(s2, s1));
	}
	
	@Test
	public void mostFrequentCharsInString() {
		String s = "abcbab";
		assertEquals(Character.valueOf('b'), Strings.mostFrequentChar(s));
	}

}
