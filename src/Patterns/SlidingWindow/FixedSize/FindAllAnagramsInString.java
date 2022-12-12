package Patterns.SlidingWindow.FixedSize;

// String Anagrams (hard) #
//Given a string and a pattern, find all anagrams of the pattern in the given string.
//
//Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
//
//abc
//acb
//bac
//bca
//cab
//cba
//Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
//
//Example 1:
//
//Input: String="ppqp", Pattern="pq"
//Output: [1, 2]
//Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
//Example 2:
//
//Input: String="abbcabc", Pattern="abc"
//Output: [2, 3, 4]
//Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String ptr = "abc";
        String str = "abbcabc";
        int[] res = FindAllAnagramsInStringFun(ptr, str);
        res = FindAllAnagramsInStringFun("pq", "ppqp");

        System.out.println("value " + res + " with target " + str);
//        res = FindAllAnagramsInString("abc", "odicf");
//        System.out.println("value " + res + " with target " + str);
//        res = FindAllAnagramsInString("bcdyabcdx", "bcdxabcdy");
//        System.out.println("value " + res );
//        res = FindAllAnagramsInString("abc", "aaacb");
//        System.out.println("value " + res );
    }

    // The idea is to use int[128] array to represent occurence of each character.
    // Here we assume that we have ASCII characters.
    private static int[] FindAllAnagramsInStringFun(String ptr, String str) {
        if (str == null || ptr == null) return new int[0];
        if (ptr.length() > str.length()) return new int[]{0};

        int[] map = new int[128];
        int start = 0;
        List<Integer> result = new ArrayList<>();

        // increment the occurence of each character for the ptr
        // for abc string -> [1,1,1, 0, 0, 0.....]
        for (char ch : ptr.toCharArray()) {
            map[ch]++;
        }

        int counter = ptr.length();

        for (int end = 0; end < str.length(); end++) {
            char ch_end = str.charAt(end);
            // simply decrement the map value of each character. It is kind of confusing right now like why are
            // we decremented values for the character which are not part of the pattern. It will get clear
            // when we break the window size.
            map[ch_end]--;
            if(map[ch_end] >= 0) counter--;

            if(end - start + 1 > ptr.length()) {
                char ch_start = str.charAt(start++);
                // increment the map count for the character going out of the window.
                map[ch_start]++;
                // now if you notice, before we actually started current for loop, we  have already incremented
                // the map count for ptr character
                // Also, we decrement the count for every character in the str
                // with this understanding, only those character which were part of the ptr will have postive value
                // rest will have zero or negative values.
                if(map[ch_start] > 0) counter++;
            }

            if(counter == 0) {
                result.add(start);
            }
        }
        System.out.println("-----");
        result.forEach(x -> {System.out.print(x + " ");});
        System.out.println("-----");
        return result.stream().mapToInt(x ->x).toArray();
    }
}
