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
        String target = "ABC";
        String str = "ADOBECODEBANC";
  //      String res = MinimumWindowSubstringFun(target, str);
  //      System.out.println("size " + res + " with target " + target);
        String res2 = minimumWindowSubStringSimplified(target, str);
    }

    //https://medium.com/kode-shaft/solve-minimum-window-substring-problem-9cb3544eeb91

    private static String minimumWindowSubStringSimplified(String t, String s){
        if(s == null || t == null) return "";

            // ASCII is used which is 128 characters so this is why a 128 array size is used.
        int[] map = new int[128];
        for(char ch: t.toCharArray()) map[ch]++;

        int start = 0, min = Integer.MAX_VALUE, counter = t.length(), min_start = -1;
        for(int end = 0; end < s.length(); end++) {
            char ch_end = s.charAt(end);
            // it means we encounter the character
            if(map[ch_end] > 0) counter --;

            // just decrement the counter for all the cases
            map[ch_end]--;

            while(counter == 0) {
                char ch_start = s.charAt(start);
                if(end - start + 1 < min) {
                    min = end - start + 1;
                    min_start = start;
                }

                // only those character which are part of the t will become zero rest of them are negative.
                map[ch_start]++; // now we are going out of window, simply incrment the counter of the character
                // if the character is from the t string then it will be > 0 if not then it will be zero max.
                // and this is the reason we are decrementing everytime. check line number 54.

                if(map[ch_start] > 0 ) counter++; // increment the counter since the character we interested in 
                start++;
            }
        }
        String result = min == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start + min);
        return  result;

//
//        int[] target_map = new int[56];
//        int[] source_map = new int[56];
//        for(char ch : t.toCharArray()) {
//            target_map[ch - 'a']++;
//        }
//
//        int start = 0;
//        int min = Integer.MAX_VALUE;
//
//        // iterate over the string
//        // if character exists in the target map then increment the count in the source map
//        // if character in the source map == 1 then increment the count
//        // if count == t.Length then
//        //      - Get the start character
//        //          - if start character exists in the target map then reduces its count from the source map
//        //              and if count == 0 then reduce the count
//        //        recalculate the min
//        // return min
//        int count = 0;
//        for(int end = 0; end < s.length(); end++) {
//            char ch_end = s.charAt(end);
//
//            if (target_map[ch_end - 'a'] > 0) {
//                source_map[ch_end - 'a']++;
//            }
//            if (source_map[ch_end - 'a'] == target_map[ch_end - 'a']) count += target_map[ch_end - 'a'];
//
//            while (count > t.length()) {
//                char ch_start = s.charAt(start);
//                // we are interested in this character
//                if (target_map[ch_start - 'a'] > 0) {
//                    source_map[ch_start - 'a']--;
//                }
//                // now check if it is the last character in the source_map
//                if (source_map[ch_start - 'a'] == 0) count -= target_map[ch_start - 'a'];
//                start++;
//            }
//
//            if (count == t.length())
//                min = Math.min(min, end - start + 1);
//        }
//
//        return min;
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
