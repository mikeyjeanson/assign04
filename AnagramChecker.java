package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class represents a tool for checking anagrams from files and string arrays.
 * @author Mikey Jeanson and Jose Mattam
 */
public class AnagramChecker {

	/**
	 * @param String needed to be sorted
	 * @returns the lexicographically-sorted version of the input string
	 */
	public static String sort(String str) {
		str = str.toUpperCase();
		char[] arr = str.toCharArray();

		Character[] characters = new Character[arr.length];

		for (int j = 0; j < arr.length; j++) {
			characters[j] = arr[j];
		}

		insertionSort(characters, (o1, o2) -> o1 - o2);
		str = "";
		for (int i = 0; i < arr.length; i++) {
			str += characters[i];
		}

		return str;
	}

	/**
	 * Sorts an array of type T, and sorts the array based on the comparator
	 * @param arr of type T
	 * @param comparator
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> c) {

		for (int i = 0; i < arr.length; i++) {
			T z = arr[i];
			int j;
			for (j = i - 1; j >= 0 && c.compare(arr[j], z) > 0; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = z;
		}
	}

	/**
	 * @param String s
	 * @param String r
	 * @returns true if s and r are anagrams
	 */
	public static boolean areAnagrams(String s, String r) {
		String t = sort(s);
		String v = sort(r);

		if (t.equals(v)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param filename
	 * @returns the String array of the largest anagram collections in the
	 *         file
	 */
	public static String[] getLargestAnagramGroup(String filename) {

		// open file
		File f = new File(filename);

		String fileStr = "";
		Scanner scn;
		try {
			scn = new Scanner(f);

			while (scn.hasNextLine()) {
				fileStr += scn.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			String[] empty = {};
			return empty;
		}
		if (fileStr.equals("")) {
			String[] empty = {};
			return empty;
		}
		String[] possibleAnagrams = fileStr.split("\n");

		return getLargestAnagramGroup(possibleAnagrams);
	}

	/**
	 * @param list of words
	 * @returns the String array of the largest anagram collections in the
	 *         file 
	 */
	public static String[] getLargestAnagramGroup(String[] list) {
		TreeMap<String, ArrayList<String>> anagrams = new TreeMap<>();
		insertionSort(list, (o1, o2) -> sort(o1).compareTo(sort(o2)));

		int largestSoFar = 1;
		String keyOfLargest = "";

		int i, j;
		for (i = 0; i < list.length; i++) {

			String sortedStr = sort(list[i]);
			ArrayList<String> tempList = new ArrayList<>(); // makes the list to add anagrams together

			if (!anagrams.containsKey(sortedStr)) {
				for (j = i; j < list.length; j++) {
					String checkStr = list[j];

					if (areAnagrams(sortedStr, checkStr)) {
						tempList.add(checkStr);
					} else {
						i = j - 1;
						break;
					}
				}

				anagrams.put(sortedStr, tempList); // puts the anagrams into tree map

				if (tempList.size() > largestSoFar) // finds the largest anagram group
				{
					largestSoFar = tempList.size();
					keyOfLargest = sortedStr;
				}
			}
		}

		if (keyOfLargest.equals("")) {
			String[] empty = {};
			return empty;
		}
		int arraySize = anagrams.get(keyOfLargest).size();

		String[] returnList = new String[arraySize];
		anagrams.get(keyOfLargest).toArray(returnList);

		return returnList;
	}

}
