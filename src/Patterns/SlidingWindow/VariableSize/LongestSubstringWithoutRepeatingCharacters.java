package Patterns.SlidingWindow.VariableSize;

import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Given a string s, find the length of the longest substring without repeating characters.
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "pwwpkews";
        int res = simplified(str);// LongestSubstringWithoutRepeatingCharactersFun(str);
        System.out.println("size " + res);
        res = simplified("pwwkew");
    }

    private static int simplified(String str) {
        if(str == null || str.length() == 0) return 0;

        // use ascii value
        int[] map = new int[256];
        int start = 0;
        int max = 0;
        for(int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);
            map[ch]++;

            while(map[ch] > 1) {
                char ch_start = str.charAt(start++);
                map[ch_start]--;
            }
            max = Math.max(max, end - start + 1);
        }
        return  max;
    }

    private static int LongestSubstringWithoutRepeatingCharactersFun( String str) {
        if(str == null || str.length() == 0) return 0;

        // we will use set to know if the given character already exists or not
        // if not simply add it.
        // if it is already exists then keep removing element unlels given character doesn't exists in the set.
        HashSet<Character> set = new HashSet<>();

        int start = 0;
        int max = 0;

        for(int end = 0; end < str.length(); end++) {
            char ch_end = str.charAt(end);

            // check if character exists and keep removing until it is removed.
            while(set.contains(ch_end)) {
                char ch_start = str.charAt(start);
                set.remove(ch_start);
                start++;
            }

            set.add(ch_end);
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
