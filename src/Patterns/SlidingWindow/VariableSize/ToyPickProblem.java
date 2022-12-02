package Patterns.SlidingWindow.VariableSize;

import java.util.HashMap;
import java.util.Map;

public class ToyPickProblem {
    
    // John is at a toy store help him pick maximum number of toys. He can only select in a continuous manner, and he can select only two types of toys.
    //
    // There are number of toys however kid can choose max of two type of toys in continuation.
    // cat, mat, cat, cat, rat, rat, cat
    // 0    1     2     3   4   5     6
    // In this case, to maximize benifit, a user must choose 2,3,4,5,6.
    
    public static void main(String[] args) {
        String[] toys = new String[] { "cat", "mat", "cat", "cat", "rat", "rat", "cat"  };
        int res = ToyPickProblemFun(toys);
        System.out.println("size " + res);
    }

    private static int ToyPickProblemFun(String[] toys) {

        if(toys.length == 0 || toys.length == 1) return toys.length;

        // define map to hold unique toys count
        Map<String, Integer> map = new HashMap<>();

        int start = 0;
        int max = 0;
        int cur_count = 0;

        for(int end = 0; end < toys.length; end++) {
            String at_end = toys[end];

            while(map.size() == 2 && !map.containsKey(at_end)) {
                String at_start = toys[start];
                cur_count--;
                if(map.get(at_start) == 1) map.remove(at_start);
                else map.put(at_start, map.get(at_start) - 1);
                start++;
            }
            cur_count++;
            map.put(at_end, map.getOrDefault(at_end, 0) + 1);
            max = Math.max(max, end - start + 1);
        }

        return max;
    }

}
