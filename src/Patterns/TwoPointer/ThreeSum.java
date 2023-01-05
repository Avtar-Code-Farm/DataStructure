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
        int[] nums = new int [] {-1,0,1,2,-1,-4};
        List<List<Integer>> result = printThreeSumPairWithSumZero(nums , 0);
    }


    private static List<List<Integer>>  printThreeSumPairWithSumZero(int[] nums, int k) {
        // first sort it
        // then use the two sum solution
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // to make three sum we can pick item upto nums.lenght - 2
        for(int i = 0; i < nums.length - 2 ; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int start = i + 1;
                int end = nums.length - 1;
                int target = k-nums[i]; // remove the current number from the k. Next we need to find if there is pair with the left out value.

                twoSum(nums, start, end, target, result);


            }

        }
        return result;
    }

    private static void twoSum(int[] nums, int start, int end, int target, List<List<Integer>> result) {
        int l = start;
        int r = end;
        while(l < r) {
            if(nums[l] + nums[r] == target) {
                result.add(Arrays.asList(nums[start - 1], nums[l], nums[r]));
                l++;
                r--;
            } else if ( nums[l] + nums[r] < target) {
                l++;
            } else
                r--;
        }
    }

//    private static void checkSumPair(int[] nums, int target, int start, int end) {
//        while(start < end) {
//            if(nums[start] + nums[end] == target){
//                int[] res = {nums[start], nums[end]};
//                return res;
//            } else if(nums[start] + nums[end] > target) {
//                end--;
//            } else
//                start++;
//        }
//    }
}
