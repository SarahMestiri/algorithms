package cracking.code.exercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Exercice {
//is it you
	public boolean isPermutationPalindrome(String s) {

		Set<Character> oddList = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (!oddList.add(c))
				oddList.remove(c);
		}
		return oddList.size() <= 1;
	}

	public String onePermutation(String S, String T) {
		int N = S.length();
		int M = T.length();
		if (N == M) {
			// check if it's a permutation or not
			if (S.equals(T))
				return "NOTHING";
			boolean onEditDifferent = false;
			String result = "";
			for (int i = 0; i < M; i++) {
				if (T.charAt(i) != S.charAt(i)) {
					if (onEditDifferent)
						return "IMPOSSIBLE";
					else {
						onEditDifferent = true;
						result = "SWAP" + S.charAt(i) + " " + T.charAt(i);

					}
				}
			}

			return result;
		}
		// if INSERT operation
		else if (M - 1 == N) {
			String result = "";
			int index1 = 0;
			int index2 = 0;
			while (index1 < M && index2 < N) {
				if (T.charAt(index1) != T.charAt(index2)) {
					if (index1 != index2)
						return "IMPOSSIBLE";
					index2++;
				} else {
					index1++;
					index2++;
				}
			}

			return result ;

		}
		// delete operation
		else if (M + 1 == N) {
			String result = "";
			int index1 = 0;
			int index2 = 0;
			while (index1 < N && index2 < M) {
				if (S.charAt(index1) != T.charAt(index2)) {
					if (index1 != index2)
						return "IMPOSSIBLE";
					index2++;
				} else {
					index1++;
					index2++;
				}
			}

			return result ;

		}
		return "IMPOSSIBLE";
	}

	public boolean isOneEditAway(String s1, String s2) {
		if (s1.length() - 1 == s2.length()) {
			return oneEditInsert(s1, s2);
		} else if (s1.length() + 1 == s2.length())
			return oneEditInsert(s2, s1);
		else if (s1.length() == s2.length())
			return oneEditReplacement(s1, s2);
		return false;
	}

	private boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2)
					return false;
				index2++;
			} else {
				index1++;
				index2++;
			}
		}

		return true;
	}

	private boolean oneEditReplacement(String s1, String s2) {
		boolean onEditDifferent = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (onEditDifferent)
					return false;
				onEditDifferent = true;
			}
		}
		return true;
	}

	public String removeSpaces(String s) {
		StringBuilder result = new StringBuilder(s);
		int countSpaces = 0; // abbrev cs later
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				result.deleteCharAt(i - countSpaces);
				countSpaces++;
			}
		}
		return result.toString();
	}

	public String reverseWords(String S) {
		int i = 0;
		StringBuilder result = new StringBuilder();
		for (int j = 0; j < S.length(); j++) {
			String word = new String();
			if (S.charAt(j) == ' ') {
				word = reverse(S.substring(i, j));
				result.append(word + " ");
				i = j + 1;
			}
		}
		String lastWord = reverse(S.substring(i, S.length()));
		result.append(lastWord);
		return result.toString();
	}

	public String reverse(String s) {
		String result = "";
		char[] array = s.toCharArray();
		for (int i = array.length - 1; i >= 0; i--) {
			result += array[i];
		}
		return result;
	}

	public Character firstNonRepeatedChar(String s) {
		char[] strChar = s.toCharArray();
		for (char c : strChar) {
			if (s.lastIndexOf(c) == s.indexOf(c))
				return c;
		}
		return null;
	}

	/*
	 * public List<String> getPermutations(String s){ List<String> permuts = new
	 * ArrayList<String>(); if(s.length() == 1) return s; for(int i = 0;
	 * i<s.length();i++){
	 * 
	 * } return permuts; }
	 */

	public int fibonnaci(int n) {
		if (n <= 1)
			return n;
		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i < n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n - 1] + memo[n - 2];
	}

	/*
	 * str = abcde permutations = [] first = a remainder = bcde getPerms(bcde)
	 * => getPerms(cde)=> getPerms(de) => getPerms(e) => getPerms("")
	 * getPerms(""): words="" permutations = "" getPerms(de) = permutations =
	 * [de, ed] getPerms(cde): permutations =[ cde, dce,dec, ced, ecd, edc]
	 * 
	 * 
	 */
	public ArrayList<String> getPerms(String str) {
		if (str == null)
			return null;
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0);
		String remainder = str.substring(1);

		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j < word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;

	}

	public String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

	public int solution(int[] A) {
		int maxSize = 0;
		// initialize the list where to put every beginning slice of maximum
		// size
		List<Integer> beginSlice = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			int startSlice = i;
			int j = i + 1;
			// initialize current max
			int currMax = 0;
			// compare each i with its consecutive
			// and stop when A[i+1> < A[i] or A.length is reached
			while (j < A.length && A[j] > A[i]) {
				// update current maximum size slice
				currMax = j - startSlice + 1;
				i++;
				j = i + 1;
			}
			// compare current maximum size slice with the maximum size
			if (currMax > maxSize) {
				// remove all old beginning slices of previous maximum size
				if (!beginSlice.isEmpty())
					beginSlice.removeAll(beginSlice);
				// add beginning slice to the list
				beginSlice.add(startSlice);
				// update maximum size
				maxSize = currMax;
				System.out.println("start slice: " + startSlice);
			} else if (currMax == maxSize) {
				beginSlice.add(startSlice);
				System.out.println("start slice: " + startSlice);
			}
		}
		System.out.println(beginSlice.size());
		// return any beginning slice of A of maximum size
		Random randomizer = new Random();
		Integer randomBSlice = beginSlice.get(randomizer.nextInt(beginSlice.size()));
		return randomBSlice.intValue();

	}

	// solution from
	// https://discuss.leetcode.com/topic/198/maximum-alternating-slice-size/18
	public int maxAlternatingSubarray(int[] a) {
		if (a.length <= 1)
			return a.length;
		int curRes = 0;
		int maxRes = 0;
		int i = 0;
		while (i < a.length && a[i] == 0) {
			curRes++;
			i++;
		}
		if (i < a.length) {
			int zeros = 0;
			int prevNonZero = a[i];
			curRes++;
			i++;
			while (i < a.length) {
				if (a[i] == 0) {
					curRes++;
					zeros++;
				} else {
					if ((a[i] > 0 && prevNonZero > 0) || (a[i] < 0 && prevNonZero < 0)) {
						if (zeros > 0) {
							if (zeros % 2 == 1)
								curRes += 1;
							else {
								maxRes = Math.max(maxRes, curRes);
								curRes = zeros + 1;
							}
							zeros = 0;
						} else {
							maxRes = Math.max(maxRes, curRes);
							curRes = zeros + 1;
						}
					} else {
						if (zeros == 0)
							curRes++;
						else {
							if (zeros % 2 == 0) {
								curRes += 1;
							} else {
								maxRes = Math.max(maxRes, curRes);
								curRes = zeros + 1;
							}
							zeros = 0;
						}
					}
					prevNonZero = a[i];
				}
				i++;
			}
		}
		maxRes = Math.max(maxRes, curRes);
		return maxRes;
	}

	public int findMaxZerosArray(int[] arr) {
		// initialize max count of 0s - count of 1s to zero
		int max_diff = 0;
		// initialize count of original zeros
		int zerosCount = 0;

		for (int i = 0; i < arr.length; i++) {

			// update original zeros count
			if (arr[i] == 0)
				zerosCount++;

			// init count of 0s and count of 1s
			int count0 = 0;
			int count1 = 0;

			for (int j = i; j < arr.length; j++) {
				if (arr[j] == 1)
					count1++;
				else
					count0++;
			}

		}
		//
		return zerosCount + max_diff;
	}

	public boolean isSameText(String s, String t) {
		// count length by adding the sum of digits and the sum of letters
		int LS = countLength(s);
		int LT = countLength(t);
		// check if the two strings have not the same length
		if (LT != LS)
			return false;
		// determine each identified letter position in String s
		Map<Integer, Character> mapLettersS = findLettersPos(s);
		// determine each identified letter position in String t
		Map<Integer, Character> mapLettersT = findLettersPos(t);
		boolean result = true;
		if (!checkSamePos(mapLettersS, mapLettersT))
			return false;
		result = checkSamePos(mapLettersT, mapLettersS);
		return result;
	}

	public int countLength(String s) {

		int sumDigits = 0;
		int sumLetter = 0;
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i]))
				sumLetter++;
			else
				sumDigits = sumDigits + Character.getNumericValue(charArray[i]);
		}
		return sumDigits + sumLetter - 1;
	}

	public Map<Integer, Character> findLettersPos(String s) {
		Map<Integer, Character> mapLettersPos = new HashMap<Integer, Character>();
		// difference between chars position with consideration of numeric
		// number
		int diff = 0;
		for (int i = 0; i < s.length(); i++) {

			// here have to check if there is a digit before
			if (Character.isLetter(s.charAt(i)))
				if (diff > 0)
					mapLettersPos.put(i + diff - 1, s.charAt(i));
				else
					mapLettersPos.put(i, s.charAt(i));
			else {
				diff += Character.getNumericValue(s.charAt(i));

				int j = i + Character.getNumericValue(s.charAt(i));
				if (i + 1 < s.length())
					mapLettersPos.put(j, s.charAt(i + 1));
				i = i + 1;
			}
		}
		return mapLettersPos;
	}

	public boolean checkSamePos(Map<Integer, Character> map1, Map<Integer, Character> map2) {
		for (int i = 0; i < map1.keySet().size(); i++) { // use iterator instead
															// of for
			if (map1.containsKey(i) && map2.containsKey(i)) {
				if (map1.get(i).equals(map2.get(i)))
					continue;
				return false;
			}
		}
		return true;
	}

	public String zigZagConvert(String s, int numRows) {

		StringBuilder result = new StringBuilder();
		if (numRows == 1)
			return s;
		int step = 2 * numRows - 2;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < s.length(); j = j + step) {
					result.append(s.charAt(j));
				}
			} else {
				int j = i;
				boolean flag = true;
				int step1 = 2 * (numRows - 1 - i);
				int step2 = step - step1;
				while (j < s.length()) {
					result.append(s.charAt(j));
					if (flag)
						j = j + step1;
					else
						j = j + step2;
					flag = !flag;
				}
			}
		}
		return result.toString();
	}

	public int[] findSubstringAllWords(String s, List<String> words) {

		int lengthW = words.get(0).length();
		int numberWords = words.size();

		StringBuilder sB = new StringBuilder(s);

		int curI = 0;

		while (curI < s.length()) {
			String word = s.substring(curI, curI + lengthW);
			if (words.contains(word)) {

				curI = curI + lengthW;
			}

		}

		return null;
	}

	public String findSmallestSubstring(String str1, String str2) {
		int l = str1.length();
		int s = str2.length();
		// check if str1 length is smaller than str2 length
		if (l < s)
			return "";
		// string map: found characters
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		// patter map: characters to find
		HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();

		// need to found characters occurences
		for (int i = 0; i < s; i++)
			if (pMap.containsKey(str2.charAt(i)))
				pMap.put(str2.charAt(i), pMap.get(str2.charAt(i)) + 1);
			else
				pMap.put(str2.charAt(i), 1);
		// start position of window search
		int start = 0;
		// start index of found window
		int start_index = -1;
		// minimum length initialisation
		int min_length = Integer.MAX_VALUE;
		// counter of found pattern chars in string
		int count = 0;

		for (int i = 0; i < l; i++) {
			// found char
			char sc = str1.charAt(i);
			// update occurence of found characters in string
			if (sMap.containsKey(sc))
				sMap.put(sc, sMap.get(sc) + 1);
			else
				sMap.put(sc, 1);

			if (pMap.containsKey(sc) && sMap.get(sc) <= pMap.get(sc))
				count++;

			if (count == s) {
				while (pMap.getOrDefault(str1.charAt(start), 0) == 0
						|| sMap.get(str1.charAt(start)) > pMap.getOrDefault(str1.charAt(start), 0)) {
					if (sMap.get(str1.charAt(start)) > pMap.getOrDefault(str1.charAt(start), 0))
						sMap.put(str1.charAt(start), sMap.get(str1.charAt(start)) - 1);
					start++;
				}
				int length_window = i - start + 1;
				if (min_length > length_window) {
					min_length = length_window;
					start_index = start;
				}
			}

		}
		if (start_index == -1)
			return "";
		return str1.substring(start_index, min_length + start_index);

	}

	public String reverseNotSpecialChar(String s) {
		if (s.length() == 0)
			return "";
		if (s.length() == 1)
			return s;
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (!isAlphabetic(s.charAt(start)))
				start++;
			else if (!isAlphabetic(s.charAt(end)))
				end--;
			else {
				s = swap(s, start, end);
				start++;
				end--;
			}
		}

		return s;
	}

	public boolean isAlphabetic(char c) {
		return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z');
	}

	public String swap(String str, int s, int e) {
		char start = str.charAt(s);
		char end = str.charAt(e);
		StringBuilder str1 = new StringBuilder(str);
		str1.setCharAt(s, end);
		str1.setCharAt(e, start);
		return str1.toString();
	}

	public int countTripletSmallerSum(int[] arr, int sum) {
		Arrays.sort(arr);
		int result = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int j = i + 1;
			int k = arr.length - 1;
			while (j < k) {
				if (arr[i] + arr[j] + arr[k] >= sum)
					k--;

				else {
					result += k - j;
					j++;
				}
			}
		}
		return result;
	}

	public void generateArrays(int ar1[], int ar2[], int index_of_a, int index_of_b, Stack<Integer> st, boolean first) {
		if (index_of_a >= ar1.length || index_of_b >= ar2.length) {
			st.pop();
			System.out.println("after pop exeeded length " + st);
			return;
		}

		// take from second if available
		if (!first) {
			for (int j = index_of_b; j < ar2.length; j++) {
				if (ar1[index_of_a] < ar2[j]) {
					st.push(ar2[j]);
					System.out.println(st);
					generateArrays(ar1, ar2, index_of_a + 1, j, st, true);
				}
			}
		}

		// take from first if available
		else if (first) {
			for (int i = index_of_a; i < ar1.length; i++) {
				if (ar1[i] > ar2[index_of_b]) {
					st.push(ar1[i]);
					// System.out.println(st);
					generateArrays(ar1, ar2, i, index_of_b + 1, st, false);
				}
			}
		}

		st.pop();
		System.out.println("At the end of the method " + st);
	}

	public int frogCrossRiver(int X, int[] A) {
		if (A.length < X)
			return -1;
		if (A.length == 1 && X == 1)
			return 0;
		int[] vDestT = new int[A.length];
		int j = 0;
		// find times where X is visited
		// sort the array vDestT increasing order
		for (int i = 0; i < A.length; i++) {
			if (A[i] == X && i >= X) {
				// int temp = 0;
				if (j > 0 && i < vDestT[j - 1]) {
					int temp = vDestT[j - 1];
					vDestT[j - 1] = i;
					vDestT[j] = temp;
				} else
					vDestT[j] = i;
				j++;
			}
		}

		int k = 0;
		while (k < vDestT.length) {
			int remainP = X - 1;
			int remainT = vDestT[k] - 1;
			// check A[0..X-1]
			while (remainT >= remainP) {
				if (A[remainT] < X) {
					remainP--;
				}
				if (remainP == 0)
					return vDestT[k];
				remainT--;
			}
			if (remainT < remainP) {
				k++;
				continue;
			}

		}
		return -1;
	}

	/*** Not by me **/
	public int frogRiverOne(int X, int[] A) {
		HashSet<Integer> hset = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= X)
				hset.add(A[i]);
			if (hset.size() == X)
				return i;
		}

		return -1;
	}

	public int isArrayPermut(int[] A) {

		Set<Integer> mapNumbers = new HashSet<Integer>();
		int N = A.length;
		int c = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 1 && A[i] <= N && mapNumbers.add(A[i]))
				c++;
			if (c == N)
				return 1;
		}
		return 0;
	}

	/** Not by me **/
	public int[] maxCounters(int N, int[] A) {
		int[] counters = new int[N];
		int MAX_COUNTER = 0;
		int MAX_COUNTER_COMMON = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 1 && A[i] <= N) {
				if ((counters[A[i] - 1] + 1 <= MAX_COUNTER_COMMON)) {
					counters[A[i] - 1] = MAX_COUNTER_COMMON + 1;
				} else {
					counters[A[i] - 1] = counters[A[i] - 1] + 1;
				}
				if (counters[A[i] - 1] > MAX_COUNTER) {
					MAX_COUNTER = counters[A[i] - 1];
				}

			} else if (A[i] == N + 1) {
				MAX_COUNTER_COMMON = MAX_COUNTER;
			}
		}

		for (int j = 0; j < N; j++) {
			if ((A[A.length - 1] == N + 1) || counters[j] < MAX_COUNTER_COMMON) {
				counters[j] = MAX_COUNTER_COMMON;
			}
		}
		return counters;

	}

	/** Not by me **/
	public int passingCars(int[] A) {
		long east = 0;
		long passingCars = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				east++;
			} else {
				passingCars += east;
			}
		}
		return passingCars > 1000000000 ? -1 : (int) passingCars;
	}

	public int equilibrum(int[] A) {

		int N = A.length;
		if (N == 0)
			return -1;
		int sR = 0;
		int sL = A[0];
		int[] eq = new int[N - 1];

		for (int i = 2; i < N; i++) {
			sR += A[i];
		}
		int i = 1;
		int cj = 0;
		while (i < N - 1) {
			if (sL == sR) {
				eq[cj] = i;
				cj++;

			}
			sL += A[i];
			sR -= A[i];
			i++;
		}
		Random random = new Random();
		// System.out.println(eq[random.nextInt(eq.length)]);
		return eq[random.nextInt(eq.length)];
	}
	
	public int smallestNumberNotEqualSubset(int[] A){
		//where to put element and calculate their sum
		Stack<Integer> st = new Stack<Integer>();
		// calculate all combination of element sum
		// sort sums of any subet in an array
		// print the first integer not figuring in the array 
		//by comparaison between sum[i] - sum[i-1] > 1
		
		return 0;
	}

}
