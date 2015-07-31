package edu.cmu.lloyddsilva;

import java.util.HashMap;

public class LongestSubstring {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcdcfgahfd"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("b"));
		System.out.println(lengthOfLongestSubstring("cccccccc"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s==null)
			return 0;
		
		boolean[] exist = new boolean[256];
		int start = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			while (exist[s.charAt(j)]) {
				exist[s.charAt(start)] = false;
				start++;
			}
			exist[s.charAt(j)] = true;
			maxLen = Math.max(j - start + 1, maxLen);
		}

		return maxLen;

	}

	public static int lengthOfLongestSubstringMap(String s) {
		if(s==null)
			return 0;
		char[] arr = s.toCharArray();
		int pre = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}

		return Math.max(pre, map.size());
	}
}
