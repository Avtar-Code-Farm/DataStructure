package Patterns.Subsets;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();

        dfs_PermutationOfDuplicateNumber(ans, temp, nums, new boolean[nums.length]);
    }

    private static void dfs_PermutationOfDuplicateNumber(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) ans.add(new ArrayList<>(temp));

        for(int i = 0; i < nums.length; i++) {
            if(used[i] == true) continue;
            else if( i > 0 && !used[i-1]   && nums[i-1] == nums[i]) continue;

            used[i] = true;
            temp.add(nums[i]);
            dfs_PermutationOfDuplicateNumber(ans, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
