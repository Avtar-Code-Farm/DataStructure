package Patterns.Subsets;

import java.util.ArrayList;
import java.util.List;

public class FindAllDistinctSubsetsForArrayWithDublicatesNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        //helper(nums , 0, new ArrayList<Integer>() , ans);
       // FindAllDistinctSubsetsForArrayWithDublicatesNumbersfun(nums , 0, new ArrayList<Integer>() , ans);
        dfs(ans, temp, nums, 0 );
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        // add the state of temp into the ans
        ans.add(new ArrayList<>(temp));

        // now loop throught start position to the end and call the depth first search for each position
        for(int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(ans, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }

    static void FindAllDistinctSubsetsForArrayWithDublicatesNumbersfun(int nums[], int ci, List<Integer> subset, List<List<Integer>> ans)
    {
        // base case when the current index reaches the length of the nums array
        if(ci == nums.length) {
            ans.add(new ArrayList<>(subset));
        } else {
            // Add the current element into the current set and continue the recursive path.
            //  don't add element which is same as next element
            while(ci < nums.length - 1 && (nums[ci] == nums[ci + 1] ) )
            {
                ci++ ;
            }


            // continue with the current set
            FindAllDistinctSubsetsForArrayWithDublicatesNumbersfun(nums, ci+1, subset, ans);


            subset.add(nums[ci]);
            FindAllDistinctSubsetsForArrayWithDublicatesNumbersfun(nums, ci + 1, subset, ans);

            // remove the last added element since it is already processed
            subset.remove(subset.size() - 1);

        }
    }
}
