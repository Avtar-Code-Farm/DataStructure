package Patterns.TwoPointer;

public class MinimumWindowSort {

    // Minimum Window Sort (medium) #
    //Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
    //
    //Example 1:
    //
    //Input: [1, 2, 5, 3, 7, 10, 9, 12]
    //Output: 5
    //Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
    //Example 2:
    //
    //Input: [1, 3, 2, 0, -1, 7, 10]
    //Output: 5
    //Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
    //Example 3:
    //
    //Input: [1, 2, 3]
    //Output: 0
    //Explanation: The array is already sorted
    //Example 4:
    //
    //Input: [3, 2, 1]
    //Output: 3
    //Explanation: The whole array needs to be sorted.

    public static void main(String[] args) {

        System.out.println(MinimumWindowSort_Fun(new int [] {1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(MinimumWindowSort_Fun(new int [] {1, 3, 2, 0, -1, 7, 10}));
        System.out.println(MinimumWindowSort_Fun(new int [] {1, 2, 3}));
        System.out.println(MinimumWindowSort_Fun(new int [] {3, 2 , 1}));
    }

    // 1) From the beginning and end of the array, find the first elements that are out of the sorting order. The two elements will be our candidate subarray.
    // 2)  Find the maximum and minimum of this subarray. This required in case minimum or max are part of the subarray
    // 3) Extend the subarray from beginning to include any number which is bigger than the minimum of the subarray.
    // 4) Similarly, extend the subarray from the end to include any number which is smaller than the maximum of the subarray.
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
