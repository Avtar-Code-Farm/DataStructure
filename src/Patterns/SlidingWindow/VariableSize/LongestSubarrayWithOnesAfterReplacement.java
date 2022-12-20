package Patterns.SlidingWindow.VariableSize;

public class LongestSubarrayWithOnesAfterReplacement {
    public static void main(String[] args) {
        int k = 3;
        int[] input = new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int res = LongestSubarrayWithOnesAfterReplacement_fun(k, input);
        System.out.println("size " + res + " with target " + k);
        res = simplified(input, k);
    }

    public static int simplified(int[] nums, int k) {
        // we need to find the window where maxium occurence of longestOnes
        // end - start + 1 - max_one_occurence > k

        int start = 0;
        int max = Integer.MIN_VALUE;
        int max_one_occurence = 0;
        int currentCount = 0;

        for(int end = 0; end < nums.length; end++) {
            if(nums[end] == 1) currentCount++;
            max_one_occurence = Math.max(max_one_occurence, currentCount);

            if(end - start + 1 - max_one_occurence > k) {
                if(nums[start] == 1) currentCount--;
                start++;
            }
            max = Math.max(max, end - start + 1);

        }
        return max;
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
