package Patterns.SlidingWindow.VariableSize;

public class LongestRepeatingCharacterReplacement_MEDIUM {
    public static void main(String[] args) {
        int target = 1;
        String str = "AABABBA";
        int res = LongestRepeatingCharacterReplacement_FUN(target, str);
        System.out.println("size " + res + " with target " + target);
    }

    private static int LongestRepeatingCharacterReplacement_FUN(int k, String str) {
        int N = str.length();
        int[] char_count= new int[26];

        int start = 0;
        int max_count = 0;
        int max_length = 0;

        for(int end = 0; end < N; end++) {
            // increment the count of the character in the map
            char_count[str.charAt(end) - 'A']++;
            int curr_len = char_count[str.charAt(end) - 'A'];
            max_count = Math.max(curr_len, max_count);

            while(end - start - max_count + 1 > k) {
                // it means we are out of operation.
                // Means we have more character then we can replace.
                // We remove the max_count to make sure that we get min size left to replace the k character

                // lets start removing character in the window  from the start
                char_count[str.charAt(start) - 'A']--;
                start++;
            }

            max_length = Math.max(end - start + 1, max_length);
        }

        return max_length;
    }
}
