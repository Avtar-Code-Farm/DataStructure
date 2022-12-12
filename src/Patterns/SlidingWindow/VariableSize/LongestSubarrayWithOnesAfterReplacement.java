package Patterns.SlidingWindow.VariableSize;

public class LongestSubarrayWithOnesAfterReplacement {
    public static void main(String[] args) {
        int k = 3;
        int[] input = new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int res = LongestSubarrayWithOnesAfterReplacement_fun(k, input);
        System.out.println("size " + res + " with target " + k);
    }

    private static int LongestSubarrayWithOnesAfterReplacement_fun(int k, int[] input) {
        if( k <= 0 || input.length == 0)
            return 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        int zero = 0;

        for(int end = 0; end < input.length; end++) {
           if(input[end] == 0) zero++;

           if(zero > k) {
               if(input[start] == 0) zero--;
               start++;
           }

           max = Math.max(max, end - start + 1);

        }
        return max;
    }


}
