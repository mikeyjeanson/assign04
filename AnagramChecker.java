package assign04;

import java.util.Comparator;

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
		//open file
		String file = "";
		
		String[] possibleAnagrams = file.split("\n");
		int i, j;
		// search every string for possible anagrams
		for(i = 0; i < possibleAnagrams.length; i++)
		{
			for (j = 0; j < 1; j++)
			{
				String str1 = "";
				String str2 = "";
				if(areAnagrams(str1, str2))
				{
					
				}
			}
		}
		return null;
	}
}
