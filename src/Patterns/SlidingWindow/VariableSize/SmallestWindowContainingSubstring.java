package Patterns.SlidingWindow.VariableSize;

public class SmallestWindowContainingSubstring {
    public static void main(String[] args) {
        String ptr = "abc";
        String str = "aabdec";

        int res = SmallestWindowContainingSubstringFun(ptr, str);
    }

    private static int SmallestWindowContainingSubstringFun(String ptr, String str) {
        if(ptr.length() > str.length()) return -1;

        int start = 0;
        int counter = ptr.length();
        int min = Integer.MAX_VALUE;
        int[] map = new int[128];

        for (char ch : ptr.toCharArray()) {
            map[ch]++;
        }

        for(int end = 0; end < str.length(); end++) {
            char ch_end = str.charAt(end);

            map[ch_end]--;
            if(map[ch_end] >= 0) counter--; // it means we hit the character from the ptr

            while(counter == 0) {
                min = Math.min(min, end - start + 1);
                char ch_start = str.charAt(start++);
                map[ch_start]++;
                if(map[ch_start] > 0) counter++; // it mans a character from the ptr is going out of the window
            }
        }
        return min;


    }
}
