package FacebookProblems.Easy;

public class PowerOfN {
    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        double res = getPower(2,10);
    }

    // The idea is to divide and concure
    // 2^10 = 2^5 * 2^5
    // 2^5 = 2 (2^2 * 2^2)
    // 2^2 = 2^1 * 2^1

    private static double getPower(int x, int n) {
        if(n == 0 ) return 1;
        if(n == 1) return x;

        double res = 1;
        if(n % 2 == 0)
            res = getPower(x * x, n/2);
        else
            res = x * getPower(x*x, n/2);
        return res;
    }
}
