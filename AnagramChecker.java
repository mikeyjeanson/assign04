package assign04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

import com.sun.java.util.jar.pack.Package.File;

public class AnagramChecker {

	/**
	 * 
	 * @param filename
	 * @return String that is sorted by lexicography
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> String sort(String str) {
		str = str.toUpperCase();
		char[] arr = str.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			char z = arr[i];
			int j;
			for (j = i - 1; j >= 0 && arr[j] > z; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = (char) z;
		}
		str = "";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i];
		}
		return str;
	}

	/**
	 * 
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> c) {

	}

	/**
	 * 
	 * @param s
	 * @param r
	 * @return true if they are anagrams
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
	 * 
	 * @param filename
	 * @return the String array of one of the largest anagram collections in the
	 *         file
	 */
	public static String[] getLargestAnagramGroup(String filename) {
		// open file

		String[] possibleAnagrams = filename.split("\n");

		return possibleAnagrams;
	}

	public static String[] getLargestAnagramGroup(String[] list) {
		int i, j;

		TreeMap<String, ArrayList<String>> anagrams = new TreeMap<>();
		int largestSoFar = 0;

		
		// search every string for possible anagrams
		for (i = 0; i < list.length; i++) {
			String str1 = sort(list[i]);
			ArrayList<String> tempList = new ArrayList<>();
			if (!anagrams.containsKey(str1)) {
				for (j = 0; j < 1; j++) {
					String str2 = list[j];
					if (areAnagrams(str1, str2)) {
						tempList.add(str2);
					}
				}
				
			}
		}
		return null;
	}
}
