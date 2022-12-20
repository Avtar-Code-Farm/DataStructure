package Patterns.TwoHeapProblems;

import java.util.PriorityQueue;

public class SlidingWindowMedian {
    static PriorityQueue<Integer> max_heap = new PriorityQueue<>((a , b) -> b-a);
    static PriorityQueue<Integer> min_heap = new PriorityQueue<>((a ,b) -> a-b);
    public static void main(String[] args) {
        int[] array = new int[]{1,4,2,3};
        int k = 4;

        printMedianForKSizeSubArray(array, k);
    }
//start  end  maxheap  minheap   FindMedian
//    0      0    1
//    0      1    1         2
//    0      2    1 -1      2           1
//    1      3    2 -1      3           2
//    1      4
    private static void printMedianForKSizeSubArray(int[] nums, int k) {
        int start = 0;
        double[] output = new double[nums.length -k + 1];
        int result_index = 0;
        for(int end = 0; end < nums.length; end++)
        {
            addNum(nums[end]);
            if(end - start + 1 > k) {
                // remove start element
                int numberToBeRemoved = nums[start];
                start++;

                // now rermove the number from the heap
                if(numberToBeRemoved > max_heap.peek()) min_heap.remove(numberToBeRemoved);
                else max_heap.remove(numberToBeRemoved);
            }
            reBalance();
            if(end - start + 1 == k) {
                double result = findMedian();
                System.out.println(result);
                output[result_index] = result;
                result_index++;
            }
        }
    }

    public static void addNum(int num) {
        // so by default we try to add a number to the max heap if there is no element exists in the max heap
        if(max_heap.size() == 0 || max_heap.peek() >= num) max_heap.add(num);
        else min_heap.add(num);
    }

    public static void reBalance(){
        // Either both the heaps will have equal numbe of elements or max heap will have one more element than min heap
        if((max_heap.size() - min_heap.size()) > 1) min_heap.add(max_heap.poll());
        else if (max_heap.size() < min_heap.size()) max_heap.add(min_heap.poll());
    }

    public static double findMedian() {
        if((max_heap.size() + min_heap.size()) % 2 == 0) {
            return ((double)(min_heap.peek())/2) + ((double)(max_heap.peek())/2);
        } else {
            // in case of odd size max heap hold the answer for the median
            return max_heap.peek();
        }
    }

}
