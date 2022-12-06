package Patterns.SlidingWindow.VariableSize;

import java.util.HashMap;
import java.util.Map;

// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//
//The testcases will be generated such that the answer is unique.
//
//
//
//Example 1:
//
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//Example 2:
//
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
//Example 3:
//
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String target = "aba";
        String str = "acbbaca";
        String res = MinimumWindowSubstringFun(target, str);
        System.out.println("size " + res + " with target " + target);
    }

    private static String MinimumWindowSubstringFun(String t, String s) {
        String result = "";

        if(t.length() > s.length()) return result;

        // Create two map. One for T string and to check the cound of each character in the window
        Map<Character, Integer> t_map = new HashMap<>();
        Map<Character, Integer> r_map = new HashMap<>();

        for(char ch : t.toCharArray()) {
            t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int min =  Integer.MAX_VALUE;
        int end = 0;

        while(end < s.length()) {
            char ch_end = s.charAt(end);

            // if ch_end doesn't exists in the t_map then continue
            if(!t_map.containsKey(ch_end)) end++;
            else {
                // We got the character we are interested in. Next simply add it to the r_map if it doesn't exists or its count is less than the count
                // exists in the t_map
                if(!r_map.containsKey(ch_end) || r_map.get(ch_end) < t_map.get(ch_end)) {
                    r_map.put(ch_end, r_map.getOrDefault(ch_end, 0) +1);
                    end++;
                } else {
                    // Now the character we are interested is already exists.
                    while(r_map.containsKey(ch_end) && r_map.get(ch_end) >= t_map.get(ch_end))
                    {
                        char ch_start = s.charAt(start++);
                        if(r_map.get(ch_start) == 1) r_map.remove(ch_start);
                        else r_map.put(ch_start, r_map.get(ch_start) - 1);
                    }
                    r_map.put(ch_end, r_map.getOrDefault(ch_end, 0) +1);
                    end++;
                }

            }

            while(t_map.equals(r_map)) {
                if(end - start + 1 < min) {
                    result = s.substring(start, end);
                    min = end - start +1;
                }
                char ch_start = s.charAt(start++);
                if(r_map.get(ch_start) == 1) r_map.remove(ch_start);
                else r_map.put(ch_start, r_map.get(ch_start) - 1);
            }

            while(start < s.length() && !t_map.containsKey(s.charAt(start))) start++;
        }

        return result;
    }
}
