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
	void testGetLargestAnagramGroup()
	{
		String[] strList = {"carets" , 
				"Caller",
				"eat",
				"cellar", 
				"recall",
				"Caters",
				"Ate",
				"caster",
				"aspired",
				"allergy", 
				"despair"};
		
		String[] anagramList = { "carets", "Caters", "caster"};
		//assertTrue(anagramList == (AnagramChecker.getLargestAnagramGroup(strList)));
		assertEquals(anagramList, AnagramChecker.getLargestAnagramGroup(strList));
	}
	
	@Test
	void testGetLargestAnagramGroup2()
	{
		assertEquals("aspired", AnagramChecker.getLargestAnagramGroup("sample_word_list.txt"));
	}
}
 