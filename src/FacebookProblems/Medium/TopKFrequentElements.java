package FacebookProblems.Medium;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7,7,7,2,2,2,2,3,3,3,3,3,3,3,3, 9, 10 ,11};
        int k = 2;
        int[] res = topKFrequentUsingHep(nums, k); // T O(nlogk)
        res = topKFrequencyUsingBucket(nums, k);
    }

    public static int[] topKFrequencyUsingBucket(int[] nums, int k)
    {
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key : count.keySet()) {
            int frequency = count.get(key);
            if(bucket[frequency] == null)
            {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int counter = 0;
        int[] res = new int[k];
        for(int pos = bucket.length -1; pos >= 0 && counter < k ; pos--) {
            if(bucket[pos] != null) {
                for(int val: bucket[pos]) {
                    res[counter++] = val;
                }
            }
        }
        return res;
    }

    public static int[] topKFrequentUsingHep(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            System.out.println(" value = " + n);
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
