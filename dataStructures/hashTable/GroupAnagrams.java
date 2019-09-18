package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Link: https://leetcode.com/problems/group-anagrams/
 * Given an array of strings, group anagrams together.

	Example:

	Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	Output:
	[
  		["ate","eat","tea"],
  		["nat","tan"],
  		["bat"]
	]
	Note:

	All inputs will be in lowercase.
	The order of your output does not matter.
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> anagrams = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String charCount = getCharCount(strs[i]);
			if (anagrams.containsKey(charCount)) {
				anagrams.get(charCount).add(strs[i]);
			} else {
				List<String> anagramGroup = new ArrayList<>();
				anagramGroup.add(strs[i]);
				anagrams.put(charCount, anagramGroup);
			}
		}
		List<List<String>> anagramGroups = new ArrayList<>();
		anagramGroups.addAll(anagrams.values());
		return anagramGroups;
	}

	public String getCharCount(String str) {
		int chars[] = new int[26];
		for (char c : str.toCharArray()) {
			chars[c - 'a']++;
		}
		StringBuilder charCount = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (chars[i] != 0) {
				charCount.append('a' + i).append(chars[i]);
			}
		}
		return charCount.toString();
	}
}
