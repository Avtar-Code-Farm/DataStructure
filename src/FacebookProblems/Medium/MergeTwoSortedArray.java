package FacebookProblems.Medium;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {5, 8 ,9 , 0 , 0 , 0};
        int m = 3;
        int[] b = {1, 4, 7};
        int n = 3;
        int[] res = merge(a, m, b, n);
    }
    /*
        5 6 7 0 0 0
        0 1 2 3 4 5

        m = 3

        non_zero_index  i
        3               0      0 6 7  5 0 0
        4               1      0 0 7  5 6 0
        5               2      0 0 0  5 6 7
     */
    static int[] merge(int[] nums1, int m,  int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;

        for(int i = nums1.length-1; i >= 0; i--) {
            if(p1 >= 0 && p2 >= 0) {
                nums1[i] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            }
            else if(p1>= 0) {
                nums1[i] = nums1[p1--];
            } else {
                nums1[i] = nums2[p2--];
            }
        }
        return nums1;

    }
}
