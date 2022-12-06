package DataStructures;


public class LinkedList {
    Node head;

    public LinkedList(int data) {
        head = new Node(data, null);
    }



    public void AddAtTheEnd(int data) {
        Node next = new Node(data, null);
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = next;
    }

    public void RemoveAtTheEnd() {
        Node temp = head;
        if(temp.next == null) head = null;

        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public Node GetLastNode() {
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        return temp;
    }

    public Node GetFirstNode() {
        return head;
    }
}
