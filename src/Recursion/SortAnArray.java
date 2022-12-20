package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SortAnArray {
    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        sort_rec(arr, arr.length - 1);

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(6);
        list.add(3);
        RecursionSort(list);
    }

    private static void RecursionInsert(List<Integer> list, int item){
        int last_index = list.size() -1 ;
        if(list.size() == 0 || list.get(last_index) <= item){
            list.add(last_index+1, item);
            return;
        }
        int x = list.get(last_index);
        list.remove(last_index);
        RecursionInsert(list, x);
        list.add(x);
    }
    private static void RecursionSort(List<Integer> list) {
        if(list.size() <= 1) return;
        int last_index = list.size() - 1;
        int temp = list.get(last_index);
        list.remove(last_index);
        RecursionSort(list);
        RecursionInsert(list, temp);
    }

    private static void sort_rec(int[] arr, int n) {
        if(n == 1) return;

        for(int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i+1])
            {
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
        }
        sort_rec(arr, n-1);
    }
}
