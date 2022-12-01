package Patterns.SlidingWindow.VariableSize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {



    public static void main(String[] args) {
        int target = 3;
        String str = "aabacbebebe";
        int res = LongestSubstringWithKUniqueCharactersFun(target, str);
        System.out.println("Min subarray size " + res + " with sum " + target);
    }

    //1. Use two pointers: start and end to represent a window.
    //2. Move end to find a valid window i.e size of map == target
    //3. When a valid window is found, set the max
    //4. Until map size > target keep reducing the character count from the map and increment the start.
    //      If character has only one occurence then remove it from the map.
    // Time complexity O(n) and space complexity O(k)
    public static int LongestSubstringWithKUniqueCharactersFun(int target, String str ) {
        int max = Integer.MIN_VALUE;

        if(str == null || str.length() < target) return -1;

        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        for(int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.size() == target) {
                max = Math.max(max, end - start + 1 );
            }

            while(map.size() > target) {
                ch = str.charAt(start);
                if(map.get(ch) == 1) map.remove(ch);
                else map.put(ch, map.get(ch) - 1);
                start++;
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
