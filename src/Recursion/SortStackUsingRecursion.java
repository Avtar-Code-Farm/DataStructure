package Recursion;

import java.util.Stack;

public class SortStackUsingRecursion {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(7);
        s.push(3);
        s.push(6);
        s.push(8);

        recusiveSort(s);
    }

    private static void recusiveSort(Stack<Integer> s) {
        if(s.size() == 0 || s.size() == 1) return;
        int stack_item = s.pop();

        recusiveSort(s);
        InsertionBackToRightPlace(s, stack_item);
    }

    private static void InsertionBackToRightPlace(Stack<Integer> s, int stack_item) {
        if(s.empty()) s.push(stack_item);
        else if(s.peek() <= stack_item) {
            s.push(stack_item);
        } else {
            int poppedIteam = s.pop();
            InsertionBackToRightPlace(s, stack_item);
            s.push(poppedIteam);
        }
    }
}

