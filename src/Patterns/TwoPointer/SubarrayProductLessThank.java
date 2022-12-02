package Patterns.TwoPointer;

import java.util.ArrayList;
import java.util.LinkedList;

public class SubarrayProductLessThank {

    public static void main(String[] args) {
        int[] nums = new int [] {8, 2, 6, 5};
        int k = 50;

        ArrayList<ArrayList<Integer>> res =  getListFun(nums, k);
    }

    private static ArrayList<ArrayList<Integer>> getListFun(int[] nums, int k) {
        int start = 0;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        int prod = 1;

        for(int end = 0; end < nums.length; end++) {
            prod = prod * nums[end];

            // We are out of the window if this is true. Lets move start to bring the calculation back to the windwo
            while(prod >= k && start < nums.length) {
                prod = prod / nums[start++];
            }

            // since the product of all the number from left to right is less than the target ->
            // all subarray from left to right wil have product < k
            // to avoid duplication, lets start from right
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for(int i = end; i >= start; i--) {
                tempList.add(0, nums[i]);
                results.add(new ArrayList<>(tempList));
            }

        }
        return results;
    }
}
