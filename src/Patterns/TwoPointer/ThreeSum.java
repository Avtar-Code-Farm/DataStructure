package Patterns.TwoPointer;

// Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
//
//Example 1:
//
//Input: [-3, 0, 1, 2, -1, 1, -2]
//Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
//Explanation: There are four unique triplets whose sum is equal to zero.


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int [] {-3, 0, 1, 2, -1, 1, -2};
        ArrayList<ArrayList<Integer>> result = printThreeSumPairWithSumZero(nums , 0);
    }

    private static ArrayList<ArrayList<Integer>>  printThreeSumPairWithSumZero(int[] nums, int k) {
        // first sort it
        // then use the two sum solution
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        // to make three sum we can pick item upto nums.lenght - 2
        for(int i = 0; i < nums.length - 2 ; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int start = i + 1;
                int end = nums.length - 1;
                int target = k-nums[i]; // remove the current number from the k. Next we need to find if there is pair with the left out value.

                int[] arr =  checkSumPair(nums, target, start, end);
                if(arr.length == 2 ) {
                    ArrayList<Integer> list = new ArrayList<Integer>();

                    list.add(nums[i]);
                    list.add(arr[0]);
                    list.add(arr[1]);
                    result.add(list);
                }

            }

        }
        return result;
    }

    private static int[] checkSumPair(int[] nums, int target, int start, int end) {
        while(start < end) {
            if(nums[start] + nums[end] == target){
                int[] res = {nums[start], nums[end]};
                return res;
            } else if(nums[start] + nums[end] > target) {
                end--;
            } else
                start++;
        }
        return new int[0];
    }
}
