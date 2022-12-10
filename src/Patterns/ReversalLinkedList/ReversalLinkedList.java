package Patterns.ReversalLinkedList;

import DataStructures.LinkedList;
import DataStructures.Node;

public class ReversalLinkedList {

    public static void main(String[] args) {

        LinkedList list = new LinkedList(8);
        list.AddAtTheEnd(7);
        list.AddAtTheEnd(6);
        list.AddAtTheEnd(5);
        list.AddAtTheEnd(4);
        list.AddAtTheEnd(3);
        list.AddAtTheEnd(2);
        list.AddAtTheEnd(1);

        Node rev = RevLinkedList(list);
        list.Print(rev);

        rev = RevNodeInKGroup(rev, 3);
        list.Print(rev);
    }

    private static Node RevNodeInKGroup(Node head, int k ) {
        //if( k <= 1 || isSizeLessThanOrEqualToK(head, k)) return head;

        Node prev = null;
        Node cur = head;
        Node next = null;
        int count = 0;

        while(cur != null && count++ < k) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // It means we have more left to process
        if(next!= null) {
            head.next = RevNodeInKGroup(next, k);
        }
        return prev;
    }

    private static boolean isSizeLessThanOrEqualToK(Node node, int k) {
        int count =0 ;
        Node temp = node;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count <= k;
    }

    private static Node RevLinkedList(LinkedList list) {
        Node head = list.GetFirstNode();

        Node prev = null;
        Node cur = head;
        Node next = null;

        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
