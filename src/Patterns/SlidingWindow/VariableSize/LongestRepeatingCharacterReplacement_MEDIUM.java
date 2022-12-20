package Patterns.SlidingWindow.VariableSize;

//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.

//https://leetcode.com/problems/longest-repeating-character-replacement/

public class LongestRepeatingCharacterReplacement_MEDIUM {
    public static void main(String[] args) {
        int target = 1;
        String str = "ABBABA";
        int res = LongestRepeatingCharacterReplacement_FUN(target, str);
        System.out.println("size " + res + " with target " + target);
    }

    private static int LongestRepeatingCharacterReplacement_FUN(int k, String str) {
        int N = str.length();
        int[] char_count= new int[26];

        int start = 0;
        int max_count = 0;
        int max_length = 0;

        for(int end = 0; end < N; end++) {
            // increment the count of the character in the map
            char_count[str.charAt(end) - 'A']++;
            int curr_len = char_count[str.charAt(end) - 'A'];
            max_count = Math.max(curr_len, max_count);

            while(end - start - max_count + 1 > k) {
                // it means we are out of operation.
                // Means we have more character then we can replace.
                // We remove the max_count to make sure that we get min size left to replace the k character

                // lets start removing character in the window  from the start
                char_count[str.charAt(start) - 'A']--;
                start++;
            }

            max_length = Math.max(end - start + 1, max_length);
        }

        return max_length;
    }
}
