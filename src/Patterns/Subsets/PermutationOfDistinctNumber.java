package Patterns.Subsets;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfDistinctNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();

        dfs_permutation(ans, temp, nums);

        characterPermutation();
    }

    private static void characterPermutation() {
        List<String> ans = new ArrayList<>();
        String str = "abcc";
        String res = "";
        boolean[] used = new boolean[str.length()];

        dfs_permutation_string(ans,str, res, used);
    }

    private static void dfs_permutation_string(List<String> ans, String str, String res, boolean[] used) {
        if(res.length() == str.length()) {
            ans.add(res);
        }
        for(int i = 0; i < str.length(); i++) {
            if(used[i] == true) continue;
            if(i > 0 && str.charAt(i) == str.charAt(i-1) && !used[i-1]) continue;

            used[i] = true;
            res = res.concat(String.valueOf(str.charAt(i)));
            dfs_permutation_string(ans, str, res, used);
            used[i] = false;
            if(res.length() == 1) res = "";
            else res = res.substring(0, res.length()-1);
        }
    }

    private static void dfs_permutation(List<List<Integer>> ans, List<Integer> temp, int[] nums) {
        if(temp.size() == nums.length) ans.add(new ArrayList<>(temp));

        for(int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            dfs_permutation(ans, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }


}
