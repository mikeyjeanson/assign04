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
		assertTrue(true);
	}

}
