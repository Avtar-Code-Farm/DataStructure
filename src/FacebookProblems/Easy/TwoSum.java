package FacebookProblems.Easy;

// https://leetcode.com/problems/two-sum/

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1,7,9,3,5,6,2};
        int target = 5;
        int[] result = FindTwoSumIndexOptimized(nums, target);
    }

    // we will use hashmap to solve two sum problem
    // Time Complexity -> O(N)
    // Space complexity -> O(N)
    public static int[] FindTwoSumIndex(int[] nums, int target) {
        if(nums.length < 2) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff) != i) {
                return new int[] {i, map.get(diff)};
            }
        }

        return new int[0];
    }

    // more optimized one --- Single loop

    public static int[] FindTwoSumIndexOptimized (int[] nums, int target) {
        if(nums.length < 2) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[]{ map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }



}
