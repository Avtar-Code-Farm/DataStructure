package FacebookProblems.Medium;

// Goal : Randomly pick an index and probability of an index chosen should depends on its %ge contribution to overall weight
//  wt[]= {1,2,3}
// percentage contribution of index - p(0) = 1/6
// percentage contribution of index - p(1) = 2/6
// percentage contribution of index - p(2) = 3/6

// First randomly choose index in the range from 0 to 2
// then find what is the weight contribution of that index with respect to entire array
// Like if you make six selection then approximatly three choises should choose w(2) and then two will choose w(1) and then
//
// Video to understand https://www.youtube.com/watch?v=fWS0TCcr-lE

public class RandomPickwithWeight {
    long[] indexs;
    long sum = 0;
    public static void main(String[] args) {

    }



    int pickIndex(){
        int l = 0;
        int r = indexs.length-1;
        double target = Math.random() * sum;

        if(target < indexs[l]) return l;

        while(l < r) {
            int m = l + (r - l)/2;
            if(target > indexs[m] && target < indexs[m+1]) return m+1;
            else if( target > indexs[m]) l = m;
            else r = m;
        }
        return -1;
    }

    void makeWeightedSum(int[] w){
        indexs = new long[w.length];
        int i= 0;
        for(int num: w){
            sum += num;
            indexs[i++] = sum;
        }
    }
}
