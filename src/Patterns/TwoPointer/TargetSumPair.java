package Patterns.TwoPointer;

public class TargetSumPair {

    public static void main(String[] args) {
        int[] nums = new int [] {1, 4, 5, 10, 23, 25, 30};
        printSumPair(nums, 28);
    }

    private static void printSumPair(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start < end) {
            if(nums[start] + nums[end] == target){
                System.out.println("Found - " + nums[start] + " and " + nums[end]);
                break;
            } else if(nums[start] + nums[end] > target) {
                end--;
            } else
                start++;
        }
    }

}
