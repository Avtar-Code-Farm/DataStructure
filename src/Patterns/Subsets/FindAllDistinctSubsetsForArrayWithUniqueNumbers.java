package Patterns.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/subsets/solutions/2915199/easy-to-understand-java-recursive-beats-92-83/

public class FindAllDistinctSubsetsForArrayWithUniqueNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 9};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(ans, temp, nums, 0 );
       // fun(nums , 0, new ArrayList<Integer>() , ans);
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        // add the state of temp into the ans
        ans.add(new ArrayList<>(temp));

        // now loop throught start position to the end and call the depth first search for each position
        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(ans, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }

    static void fun(int nums[], int ci, List<Integer> subset, List<List<Integer>> ans)
    {
        // base case when the current index reaches the length of the nums array
        if(ci == nums.length) {
            ans.add(new ArrayList<>(subset));
        } else {
            // continue with the current set
            fun(nums, ci+1, subset, ans);

            // Add the current element into the current set and continue the recursive path.
            subset.add(nums[ci]);
            fun(nums, ci+1, subset, ans);

            // remove the last added element since it is already processed
            subset.remove(subset.size()-1);
        }
    }


}
