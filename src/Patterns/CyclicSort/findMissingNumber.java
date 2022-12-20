package Patterns.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class findMissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 0 , 1, 2};
        int res = getMissingNumebrUsinBitWise(nums);

        nums = new int[]{4, 0 , 1, 2};
        res = findMissingNumberUsingCyclicSortLogic(nums);
        nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        var output = findAllTheNumberDisapperedInTheArray(nums);

        int duplicate = findTheDuplicates(new int[]{1,3,4,2,2});
    }

    private static int getMissingNumebrUsinBitWise(int[] nums) {
        int expectedXor = 0;
        for(int i = 0 ; i <= nums.length; i++) {
            expectedXor ^= i;
        }
        int actualXor = 0;
        for(int i = 0 ; i < nums.length; i++) {
            actualXor ^= nums[i];
        }
        return expectedXor ^ actualXor;
    }

    // perform cyclic sort first.
    // thirs will move all the numbers to the right place except the one which is mssing
    // the job left is to find the index which is not having right number i.e, i != num[i]
    private static int findMissingNumberUsingCyclicSortLogic(int[] nums) {
        int i = 0;
        // perform cyclic sort
        while(i < nums.length) {
            if( nums[i] < nums.length && nums[i] != nums[nums[i]]) swap(nums, i, nums[i]);
            else i++;
        }

        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i) return i;
        }
        return nums.length;
    }

    private static int findTheDuplicates(int[] nums) {
        int i = 0;
        // perform cyclic sort
        while(i < nums.length) {
            if( nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) swap(nums, i, nums[i]-1);
            else if(nums[i] != i + 1) return nums[i];
            else i++;
        }
        return -1;
    }

    private static List<Integer> findAllTheNumberDisapperedInTheArray(int[] nums) {
        int i = 0;
        List<Integer> output = new ArrayList<>();

        // perform cyclic sort
        while(i < nums.length) {
            if( nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) swap(nums, i, nums[i]-1);
            else i++;
        }

        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) output.add(i+1);
        }
        if(output.size() == 0) output.add(nums.length);
        return output;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
