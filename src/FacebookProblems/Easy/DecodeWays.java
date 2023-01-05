package FacebookProblems.Easy;

public class DecodeWays {
    static int count = 0;
    public static void main(String[] args) { 
        decode("06");
    }

    private static int decode(String s) {
        char[] input = s.toCharArray();
        decode(input, 0);
        return count;
    }

    public static void decode(char[] input, int start) {

        if(start >= input.length) {
            count++;
            return;
        }

        // process single digit;
        int num = Character.getNumericValue(input[start]);
        if(num == 0) return;
        decode(input, start+1);

        // process two digit;
        if(start >= input.length - 1) return;

        int twoNum = Character.getNumericValue(input[start]) * 10 + Character.getNumericValue(input[start+1]);
        if(twoNum > 26 || twoNum < 10) return;
        decode(input, start+2);
    }
}
