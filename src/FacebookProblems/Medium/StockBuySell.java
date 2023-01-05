package FacebookProblems.Medium;

public class StockBuySell {

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int max_profit = max_profit_by_onetransaction(a);
        max_profit = max_profit_by_multipletransaction(a);
    }

    private static int max_profit_by_multipletransaction(int[] a) {
        int profit = 0;
        for(int i = 0; i < a.length-1; i++) {
            if(a[i+1] > a[i]){
                profit += a[i+1] - a[i];
            }
        }
        return profit;
    }

    // The idea here is that we need to check if a[i] < min then set min
    // otherwise check if the we subtract the current prices from the min do we make max profit or not
    private static int max_profit_by_onetransaction(int[] a) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
            }else {
                max = Math.max(max, a[i] - min);
                // No need to set min since we are buying only once so we look after another buy only if that is lower that the current min
            }
        }
        return  min;
    }

}
