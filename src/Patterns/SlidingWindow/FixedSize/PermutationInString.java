package Patterns.SlidingWindow.FixedSize;

// Permutation in a String (hard) #
//Given a string and a pattern, find out if the string contains any permutation of the pattern.
//
//Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
//
//abc
//acb
//bac
//bca
//cab
//cba
//If a string has ‘n’ distinct characters it will have n!n! permutations.
//
//Example 1:
//
//Input: String="oidbcaf", Pattern="abc"
//Output: true
//Explanation: The string contains "bca" which is a permutation of the given pattern.
//Example 2:
//
//Input: String="odicf", Pattern="dc"
//Output: false
//Explanation: No permutation of the pattern is present in the given string as a substring.
//Example 3:
//
//Input: String="bcdxabcdy", Pattern="bcdyabcdx"
//Output: true
//Explanation: Both the string and the pattern are a permutation of each other.
//Example 4:
//
//Input: String="aaacb", Pattern="abc"
//Output: true
//Explanation: The string contains "acb" which is a permutation of the given pattern.

public class PermutationInString {
    public static void main(String[] args) {
        String ptr = "abc";
        String str = "oidbcaf";
        boolean res = false;
        res = PermutationInStringFun(ptr, str);
        System.out.println("value " + res + " with target " + str);
        res = PermutationInStringFun("abc", "odicf");
        System.out.println("value " + res + " with target " + str);
        res = PermutationInStringFun("bcdyabcdx", "bcdxabcdy");
        System.out.println("value " + res );
        res = PermutationInStringFun("abc", "aaacb");
        System.out.println("value " + res );
    }

    // The idea is to use int[128] array to represent occurence of each character.
    // Here we assume that we have ASCII characters.
    private static boolean PermutationInStringFun(String ptr, String str) {
        if (str == null || ptr == null) return false;
        if (ptr.length() > str.length()) return false;

        int[] map = new int[128];
        int start = 0;

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

            if(counter == 0) return true;

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


        }

        return false;
        }



    

}
