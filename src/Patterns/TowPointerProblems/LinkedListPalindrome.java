package Patterns.TowPointerProblems;

import DataStructures.LinkedList;
import DataStructures.Node;

public class LinkedListPalindrome {
    public static void main(String[] args) {

        LinkedList list = new LinkedList(2);
        list.AddAtTheEnd(4);
        list.AddAtTheEnd(6);
        list.AddAtTheEnd(4);
        list.AddAtTheEnd(2);


        IsPalindrome(list);

        // loop exists. Find out if this loop exist.
    }

    public static void IsPalindrome(LinkedList list) {
        Node result = IsPalindrome(list.GetFirstNode(), list.GetFirstNode());
        if(result == null) System.out.println("Non plaindrome");
        else System.out.println("plaindrome");
    }

    public static Node IsPalindrome(Node node, Node pointer) {
        if(node == null) return  null;
        if(node.next == null) {
            if(node.data == pointer.data) return pointer.next;
            else return null;
        }
        Node pre = node;
        Node start_pointer = IsPalindrome(node.next, pointer);
        if(start_pointer == null) return null;
        else if(pre.data == start_pointer.data) {
            return start_pointer.next == null ? start_pointer : start_pointer.next;
        }
        else
        {
            return null;
        }
    }
}
