package Patterns.SlidingWindow.FixedSize;


// Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
public class MaxSumArrayProblem_1 {

    public static void main(String[] args) {
        int[] nums = new int [] {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int result =  getMaxSumByKConsecutiveVariables(nums, 4);
        System.out.println("Result = " + result);
        int[] results = SingleLoopWithActualElements(nums, 4);
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

        // set the cur sum to the max
        cur = max;

        // now use the window to traverse the array
        for(int i = k; i < nums.length; i++) {
            // simply add the new end position and remove the first previous position
            cur = cur + nums[i] - nums[i-k];
            // Set the max again
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

    public static int[] SingleLoopWithActualElements(int[] nums, int k) {
        if(nums.length == 0 || k <= 0 ) return new int[0];
        int[] result = new int[k];
        int start = 0;
        int max = 0;
        int curr = 0;
        int index = 0;

        for(int end = 0; end < nums.length; end++) {
            curr += nums[end];

            // once window met increment start and set max
            if(end - start + 1 == k){
                if(curr >= max) {
                    max = curr;
                    index = 0;
                    for(int p = start; p<=end; p++) {
                        result[index++] = nums[p];
                    }
                }

                curr -= nums[start];
                start++;
            }

        }
        return result;
    }
}
