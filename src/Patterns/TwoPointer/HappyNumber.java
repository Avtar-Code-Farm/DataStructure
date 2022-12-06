package Patterns.TwoPointer;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {

      //  System.out.println(HappyNumber_FUN(23));
        System.out.println(HappyNumber_FUN(12));

    }

    private static boolean HappyNumber_FUN(int num) {
        // find the number each digit

        HashSet<Integer> set = new HashSet<>();

        int new_num = 0;
        while(num != 1 && !set.contains(num)) {
            new_num = 0;
            while(true & num > 10) {
                int last_digit = getTenthDigit(num);
                new_num += last_digit * last_digit;
                num = getNumberWithoutTenthDigit(num);
                if(num < 10) break;
            }
            new_num += num * num;
            num = new_num;
            set.add(num);
        }

        if(num == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int getTenthDigit(int num) {
        if(num < 10) return num;

        int restult = num % 10;
        return restult;
    }

    public static int getNumberWithoutTenthDigit(int num) {
        if (num < 10) return num;
        int result = num / 10;
        return result;
    }
}
