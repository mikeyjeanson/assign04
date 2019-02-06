package assign04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramCheckerTest {

	@Test
	void testSort() {
		assertEquals("Hello", AnagramChecker.sort("Hello"));
	}
	
	@Test
	void testSort2() {
		assertEquals("EHllo", AnagramChecker.sort("HEllo"));
	}

	@Test
	void testAreAnagrams() {
		assertTrue(AnagramChecker.areAnagrams("cellar", "caller"));
	}
	
	@Test
	void testAreAnagrams2() {
		assertTrue(AnagramChecker.areAnagrams("CELLAR", "caller"));
	}

	@Test
	void testGetLargestAnagramGroup() {
		String[] strList = { "carets", "Caller", "eat", "cellar", "recall", "Caters", "Ate", "caster", "aspired",
				"allergy", "despair" };

		String[] anagramList = {  "Caller", "cellar" , "recall" };

		String[] actual = AnagramChecker.getLargestAnagramGroup(strList);
		
		for (int i = 0; i < anagramList.length; i++) {
			assertEquals(actual[i], anagramList[i]);
		}
	}
	
	@Test
	void testGetLargestAnagramGroupOneElement() {
		String[] test = { "a" };
		assertEquals(0, AnagramChecker.getLargestAnagramGroup(test).length);
	}

	@Test
	void testGetLargestAnagramGroupFromFile() {
		String[] strList = { "carets",  "Caters", "caster", "crates",  "Reacts", "recast", "traces" };
		String[] actual = AnagramChecker.getLargestAnagramGroup("C:\\Users\\Jose\\Documents\\GitHub\\assign04\\sample_word_list.txt");
		for (int i = 0; i < strList.length; i++) {
			assertEquals(strList[i], actual[i]);
		}
	}
	
	@Test 
	void testGetLargestAnagramGroupFromFileEmptyFile() {
		String[] actual = AnagramChecker.getLargestAnagramGroup("C:\\Users\\Jose\\Documents\\GitHub\\assign04\\empty_text_file.txt");
		assertEquals(0, actual.length);
	}
	
	@Test 
	void testGetLargestAnagramGroupFromFileNonExistentFile() {
		String[] actual = AnagramChecker.getLargestAnagramGroup("C:\\Users\\Jose\\Documents\\GitHub\\assign04\\dne_file.txt");
		assertEquals(0, actual.length);
	}
	
	@Test
	void testSortNull() {
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.sort(null);
		});
	}
	
	@Test
	void testGetLargestAnagramGroupFromFileNull() {
		String[] nullList = null;
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.getLargestAnagramGroup(nullList);
		});
	}
	
	@Test
	void testGetLargestAnagramGroupFromFileNull2() {
		String nullFile = null;
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.getLargestAnagramGroup(nullFile);
		});
	}
	
	@Test
	void testAreAnagramsNull() {
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.areAnagrams(null, null);
		});
	}
	
	@Test
	void testInsertionSortNull() {
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.insertionSort(null, null);
		});
	}
}
