package Patterns.SlidingWindow.VariableSize;

public class LongestSubstringWithSameLettersAfterReplacement {


    public static void main(String[] args) {
        int k = 3;
        String str = "aabacbebebe";
        int res = LongestSubstringWithSameLettersAfterReplacement_FUN(k, str);
        System.out.println("size " + res + " with target " + k);
    }

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
