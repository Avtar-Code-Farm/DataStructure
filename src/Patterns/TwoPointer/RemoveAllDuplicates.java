package Patterns.TwoPointer;

public class RemoveAllDuplicates {

    public static void main(String[] args) {
        int[] nums = new int [] {2, 3, 3, 3, 6, 9, 9};
        printRemoveAllDuplicates(nums);
    }

    private static void printRemoveAllDuplicates(int[] nums) {
        int uniqu_count  = 1;

        for(int i = 1; i< nums.length; i++) {
            if(nums[i] != nums[i-1]){
                uniqu_count++;
            }
        }
        System.out.println(uniqu_count);
    }

}
