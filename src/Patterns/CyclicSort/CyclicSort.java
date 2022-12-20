package Patterns.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 5, 6, 4, 3, 2};
        sort_cyclic(nums);
        //int[] sort = sort(nums);
        int res = findMissingNumber(new int[]{4,0,3,1});
        int res2 = findMissingNumber(new int[]{8,3,5,2,4,6,0,1});

        int[] res3= findAllMissingNumber(new int[]{2, 3, 1, 8, 2, 3, 5, 1});
        int[] res4 = findAllDuplicates(new int[]{5, 4, 7, 2, 3, 5, 3});
    }

    private static void sort_cyclic(int[] nums ) {
        if(nums.length == 0) return;
        int i = 0;
        while(i < nums.length) {
            // this is required because numbers are starting from 1 to N and we cannot index a number which is > nums.length
            if(nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }

    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int[] sort(int[] nums) {
        if(nums.length <= 1) return nums;

        int i = 0;

        while(i < nums.length) {
            int correct_pos = nums[i] - 1;
            if(correct_pos < nums.length && nums[correct_pos] != nums[i]) {
                // swap between nums[correct_pos] and nums[i]
                int temp = nums[i];
                nums[i] = nums[correct_pos];
                nums[correct_pos] =temp;
            } else {
                i++;
            }
        }

        return  nums;
    }

    private static int findMissingNumber(int[] nums) {
        if(nums.length <= 1) return -1;

        int i = 0;

        while(i < nums.length) {
            int correct_pos = nums[i];
            if(correct_pos < nums.length && nums[correct_pos] != nums[i]) {
                // swap between nums[correct_pos] and nums[i]
                int temp = nums[i];
                nums[i] = nums[correct_pos];
                nums[correct_pos] =temp;
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j) return j;
        }

        return  -1;
    }

    private static int[] findAllMissingNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length <= 1) return new int[0];

        sort(nums);

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] -1 != j) list.add(j+1);
        }

        return  list.stream().mapToInt(i ->i).toArray();
    }

    // number start from 1 to n
    private static int[] findAllDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        sort(nums);

        for(int i =0 ; i < nums.length;i++) {
            if(nums[i] != i+1) result.add(nums[i]);
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}
