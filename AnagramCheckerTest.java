package assign04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramCheckerTest {

	@Test
	void sortTest() {
		assertEquals("EHLLO", AnagramChecker.sort("Hello"));
	}

	@Test
	void areAnagrams() {
		assertTrue(AnagramChecker.areAnagrams("cellar", "caller"));
	}

	@Test
	void testGetLargestAnagramGroup() {
		String[] strList = { "carets", "Caller", "eat", "cellar", "recall", "Caters", "Ate", "caster", "aspired",
				"allergy", "despair" };

		String[] anagramList = { "Caller" , "cellar" , "recall" };

		String[] actual = AnagramChecker.getLargestAnagramGroup(strList);
		
		for (int i = 0; i < anagramList.length; i++) {
			assertEquals(actual[i], anagramList[i]);
		}
	}

	@Test
	void testGetLargestAnagramGroup2() {
		String[] strList = { "carets", "Caters", "caster", "crates", "Reacts", "recast", "traces" };
		String[] actual = AnagramChecker.getLargestAnagramGroup("C:\\Users\\Jose\\Documents\\GitHub\\assign04\\sample_word_list.txt");
		for (int i = 0; i < strList.length; i++) {
			assertEquals(strList[i], actual[i]);
		}
	}
}
