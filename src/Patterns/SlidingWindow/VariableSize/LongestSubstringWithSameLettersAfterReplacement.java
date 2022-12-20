package Patterns.SlidingWindow.VariableSize;

public class LongestSubstringWithSameLettersAfterReplacement {


    public static void main(String[] args) {
        int k = 3;
        String str = "aabacbebebe";
        int res = LongestSubstringWithSameLettersAfterReplacement_FUN(k, str);
        System.out.println("size " + res + " with target " + k);
    }

    // The most imp part here is to find the window
    // i.e start - end +1 - maxoccurence of the character in the given window.
    // why max occurencae -> becuase it will help us to replace the rest of the number with k but if we get more
    // character then k it means we are going out of the window.
    private static int LongestSubstringWithSameLettersAfterReplacement_FUN(int k, String str) {
        int[] map = new int[128];

        int start = 0;
        int max = Integer.MIN_VALUE;
        int max_occurreance = 0;

        for(int end = 0 ; end < str.length(); end++) {
            char ch_end = str.charAt(end);
            map[ch_end]++;
            max_occurreance = Math.max(max_occurreance, map[ch_end]);

            // find the window i.e end - start - maxOccurrance + 1
            if(end - start + 1 - max_occurreance > k) {
                char ch_start = str.charAt(start);
                map[ch_start]--;
                start++;
            }

            max = Math.max(max, end - start + 1);

        }
        return max;
    }

}
