package code.ngill.sortingandsearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnagramSorting {

	public static void main(String[] args) {
		String words[] = new String[] { "acca", "aba", "abab", "baa", "baab", "caac" };
		System.out.println(Arrays.toString(words));
		anagramBucketSort(words);
		System.out.println(Arrays.toString(words));
		
		System.out.println();
		
		words = new String[] { "acca", "aba", "abab", "baa", "baab", "caac" };
		System.out.println(Arrays.toString(words));
		anagramSort(words);
		System.out.println(Arrays.toString(words));
		
		System.out.println();
		
		words = new String[] { "aba", "baa", "abab","baab", "acca", "caac" };
		System.out.println(Arrays.toString(words));
		anagramBucketSort(words);
		System.out.println(Arrays.toString(words));
		
		System.out.println();
		
		words = new String[] { "aba", "baa", "abab","baab", "acca", "caac" };
		System.out.println(Arrays.toString(words));
		anagramSort(words);
		System.out.println(Arrays.toString(words));
		
		System.out.println();
		
		words = new String[] { "caac", "acca", "baab", "abab", "aba", "baa" };
		System.out.println(Arrays.toString(words));
		anagramBucketSort(words);
		System.out.println(Arrays.toString(words));
		
		System.out.println();
		
		words = new String[] { "caac", "acca", "baab", "abab", "aba", "baa" };
		System.out.println(Arrays.toString(words));
		anagramSort(words);
		System.out.println(Arrays.toString(words));
	}

	private static void anagramSort(String[] words) {
		Arrays.sort(words, new AnagramComparator());
	}
	
	private static void anagramBucketSort(String[] words) {
		Map<String, List<String>> buckets = new HashMap<String, List<String>>();
		
		for(String word : words) {
			String sortedWord = sortWord(word);
			if(buckets.containsKey(sortedWord)) {
				buckets.get(sortedWord).add(word);
			} else {
				List<String> bucket = new ArrayList<String>();
				bucket.add(word);
				buckets.put(sortedWord, bucket);
			}
		}
		
		int index = 0;
		for(Map.Entry<String, List<String>> entry : buckets.entrySet()) {
			for(String word : entry.getValue()) {
				words[index] = word;
				index++;
			}
		}
	}
	
	private static String sortWord(String word) {
		char[] wordChars = word.toCharArray();
		Arrays.sort(wordChars);
		return new String(wordChars);
	}
	
	static class AnagramComparator implements Comparator<String> {

		@Override
		public int compare(String first, String second) {
			return areAnagrams(first, second) ? 0 : 1; 
		}
		
		private boolean areAnagrams(String first, String second) {
			int[] characters = new int[26];
			
			if(first.length() != second.length()) {
				return false;
			}
			
			for(char c : first.toCharArray()) {
				characters[c - 97]++;
			}
			
			for(char c : second.toCharArray()) {
				characters[c - 97]--;
			}
			
			for(int value : characters) {
				if(value != 0) {
					return false;
				}
			}
			
			return true;
		}
	}

}
