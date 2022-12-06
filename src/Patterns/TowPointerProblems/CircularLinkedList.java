package Patterns.TowPointerProblems;

import DataStructures.*;

public class CircularLinkedList {
    public static void main(String[] args) {

        LinkedList list = new LinkedList(1);
        list.AddAtTheEnd(2);
        list.AddAtTheEnd(3);
        list.AddAtTheEnd(4);

        Node last = list.GetLastNode();
        Node first = list.GetFirstNode();

        last.next = first;
        boolean res = IsLoopExists(list);

        // loop exists. Find out if this loop exist.
    }

    public static boolean IsLoopExists(LinkedList list) {
        if(list == null) return false;
        Node slow = list.GetFirstNode();
        Node fast = list.GetFirstNode();

        while(fast.next != null && fast.next.next!=null) {
            fast.next = fast.next.next;
            slow.next = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
