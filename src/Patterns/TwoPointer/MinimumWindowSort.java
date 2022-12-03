package Patterns.TwoPointer;

public class MinimumWindowSort {
    public static void main(String[] args) {

        System.out.println(MinimumWindowSort_Fun(new int [] {1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(MinimumWindowSort_Fun(new int [] {1, 3, 2, 0, -1, 7, 10}));
        System.out.println(MinimumWindowSort_Fun(new int [] {1, 2, 3}));
        System.out.println(MinimumWindowSort_Fun(new int [] {3, 2 , 1}));
    }

    private static int MinimumWindowSort_Fun(int[] nums) {
        int low = 0, high = nums.length -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // find the low index where number is greater the next element
        while(low < nums.length - 1 && nums[low] <= nums[low + 1])
            low++;

        if(low == nums.length -1 ) return 0;

        // find the high index where number is smaller than the next element
        while(high > 0 && nums[high] >= nums[high -1])
            high--;

        // find the max and min in the subarray
        for(int i = low; i <= high; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Extend the subarray from beginning to include any number which is bigger than the minimum of the subarray.
        while(low > 0 && nums[low - 1] > min) low--;
        // Extend the subarray from the end to include any number which is smaller than the max of the subarray
        while(high < nums.length-1 && nums[high + 1] < min) high++;

        return high - low + 1;

    }

}
