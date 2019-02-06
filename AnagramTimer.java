package assign04;

import java.io.File;
import java.util.Random;
import assign04.AnagramChecker;

/**
 * Timer for Simple Priority Queue
 * 
 * @author Mikey Jeanson and Jose Mattam, Erin Parker
 *
 */

public class AnagramTimer {

	private static String[] testStrings = new String[200000];
	
	private static int sizeOfStr = 0;

	public static void main(String[] args) {
		// Do 100000 inserts or findMins
		int timesToLoop = 1000;

		// For each problem size n . . .
		for (int n = 10000; n <= 200000; n += 10000) {
			
			generateStrings(n);

			long startTime, midpointTime, stopTime;

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}
			// Now, run the test.
			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop - 1; i++) {
				AnagramChecker.areAnagrams(testStrings[i], testStrings[i + 1]);
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.

			for (long i = 0; i < timesToLoop; i++) { // empty block
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;

			System.out.println("areAnagrams\t" + n + "\t" + averageTime);
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}
			// Now, run the test.
			startTime = System.nanoTime();

			String[] arrayN = new String[n];
			
			for(int j = 0; j <= n; j++)
			{
				arrayN[j] = testStrings[j];
			}
			
			
			for (int i = 0; i < timesToLoop; i++) {
				AnagramChecker.getLargestAnagramGroup(arrayN);
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.

			for (long i = 0; i < timesToLoop; i++) { // empty block
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime2 = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;

			System.out.println("getLargestGroup\t" + n + "\t" + averageTime2);
		}
	}

	private static void generateStrings(int size) {

		Random rng = new Random();

		int sizeToBuild = sizeOfStr + size;
		
		for (int i = sizeOfStr; i < sizeToBuild; i++) {
			String builtStr = "";
			int timesToLoop = 3 + rng.nextInt(5);
			for (int j = 0; j <= timesToLoop; j++) {
				builtStr += ((char) (65 + rng.nextInt(26)));
			}
			testStrings[i] = builtStr;
		}
		sizeOfStr += size;
	}
}
