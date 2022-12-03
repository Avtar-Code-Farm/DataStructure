package Patterns.SlidingWindow.FixedSize;

import java.util.*;

//438. Find All Anagrams in a String
//
// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//Example 1:
//
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
public class FindAllAnagrams {

    public static void main(String[] args) {
        String s =  "cbaebabacd";
        String p = "abc";
        //List<Integer> results = GetAllAnagrams(s,p);
        List<Integer> results = GetAllAnagramsSimplified(s,p);
    }

    public static List<Integer> GetAllAnagramsSimplified(String s, String p ){
        // we will use int[26] array to hold the count of each character occurrance
        // Again we will use the window approach. Window size = p.length()
        List<Integer> result = new ArrayList<Integer>();

        int left = 0;
        int[] smap = new int[26]; // hold occurance count in the substring of s string
        int[] pmap = new int[26];  // hold occurance count of the character in the p string

        // first load the pmap
        int k = p.length();
        for(int i = 0; i < k; i++){
            pmap[p.charAt(i) - 'a']++;
        }

        for(int right = 0; right < s.length(); right++){
            smap[s.charAt(right) - 'a']++;

            if(right - left + 1 == k) {// window limit reached
                // check if smap and pmap are equal;
                if(Arrays.equals(smap,pmap)) result.add(left);
                // now remove the left character from smap and increment it so that we can test next window
                smap[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return  result;
    }

    // We will use sliding window approach with hashmap to compare string
    public static List<Integer> GetAllAnagrams(String s, String p ) {
        List<Integer> result = new ArrayList<Integer>();

        // handle edge cases
        if(s == null || p == null) return result;
        if(p.length() > s.length()) return result;

        // pattern map holding character and its count
        Map<Character, Integer> pmap = new HashMap<Character, Integer>();
        // // input string map holding character and its count
        Map<Character, Integer> smap = new HashMap<Character, Integer>();

        // first prepare the base map for the comparision using the pattern
        for(int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pmap.put(ch, 1 + pmap.getOrDefault(ch, 0));
        }

        // To manage window
        int start = 0;
        int end = 0;

        while(end < s.length()) {
            // keep inserting the character from the input string into smap
            char ch = s.charAt(end);
            smap.put(ch, 1+ smap.getOrDefault(ch, 0));

            // once window traverse finishes, we will do comparision
            if(end >= p.length() - 1)
            {
                if(smap.equals(pmap)) result.add(start);

                // Lets remove the character which is outside the window
                char chstart = s.charAt(start);
                if(smap.get(chstart) == 1 )
                    smap.remove(chstart);
                else
                    smap.put(chstart, smap.get(chstart) -1 );
                // increment the start to set new window start pointer
                start++;
            }
            // // increment the end to set new window start pointer
            end++;
        }

        return result;

    }


}
