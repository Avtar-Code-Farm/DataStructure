package Patterns.SlidingWindow;


// Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
public class  MaxSumArrayProblem  {

    public static void main(String[] args) {
        int[] nums = new int [] {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int result =  getMaxSumByKConsecutiveVariables(nums, 4);

    }

    // Example: Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.

    // Input  : arr[] = {100, 200, 300, 400}, k = 2
    //Output : 700
    //
    //Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
    //Output : 39
    //We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.
    //
    //
    public static int getMaxSumByKConsecutiveVariables(int[] nums, int k) {
        if(nums.length < k) return -1;

        int max = 0;
        int cur = 0;

        // Calculate the first window
        for(int i = 0; i < k; i++) {
            max += nums[i];
        }

        cur = max;

        for(int i = k; i < nums.length; i++) {
            cur = cur + nums[i] - nums[i-k];
            max = Math.max(cur, max);
        }

        return max;
    }

    public static int getMaxSumByKConsecutiveVariablesWithSubArrayPrint(int[] nums, int k) {
        if(nums.length < k) return -1;

        int max = 0;
        int cur = 0;

        for(int i = 0; i < k; i++) {
            max += nums[i];
        }

        cur = max;

        int start = 0;
        int end =  k - 1;

        for(int i = k; i < nums.length; i++) {
            cur = cur + nums[i] - nums[i-k];
            if( cur > max) {
                max = cur;
                start = i-k+1;
                end = i;
            }
        }

        for(int i = start; i <= end; i++){
            System.out.println("Result " + nums[i]);
        }

        return max;
    }
}
