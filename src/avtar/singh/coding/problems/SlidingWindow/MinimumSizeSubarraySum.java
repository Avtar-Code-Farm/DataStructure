package avtar.singh.coding.problems.SlidingWindow;

public class MinimumSizeSubarraySum {

    //Given an array of integers and a number k, find the maximum sum of a subarray of size k.
    //
    //Examples:
    //
    //Input  : arr[] = {100, 200, 300, 400}
    //         k = 2
    //Output : 700
    //
    //Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
    //         k = 4
    //Output : 39
    //We get maximum sum by adding subarray {4, 2, 10, 23}
    //of size 4.
    //
    //Input  : arr[] = {2, 3}
    //         k = 3
    //Output : Invalid
    //There is no subarray of size 3 as size of whole
    //array is 2.

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[] {2,3,1,2,4,3};
        int res = minSubArrayLen(target, nums);
        System.out.println("Result " + res);
    }

    //1. Use two pointers: start and end to represent a window.
    //2. Move end to find a valid window.
    //3. When a valid window is found, move start to find a smaller window.
    public static int minSubArrayLen(int target, int[] nums ) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = nums[0];

        int min_length = Integer.MAX_VALUE;


        if(sum > target) return 1;

        while(start < nums.length)
        {
            while(end < nums.length -1 && sum < target) {
                end++;
                sum = sum + nums[end];
            }

            if(sum >= target)
                min_length = Math.min(min_length, end - start + 1);

            // remove the starting index
            sum = sum - nums[start];
            // increment the starting index
            start++;



        }
        return min_length;
    }
}
