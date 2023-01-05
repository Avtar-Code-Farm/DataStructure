package FacebookProblems.Medium;

import java.util.HashMap;

class Node {
    int val;
    int key;
    Node next;
    Node prev;
    Node(int d, int k) {
        this.val = d;
        this.key = k;
    }
}
class LRU {
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;

    public void addToLL(Node n) {
        n.next = head;
        if(head != null) {
            head.prev = n;
        }
        head = n;
        if(tail == null) {
            tail = head;
        }
    }

    public void moveElementToFront(Node node) {
        // if the node which we are moving is also the tail then update tail
        if(node == tail) {
            tail = tail.prev;
        }

        Node pre = node.prev;
        if(pre != null) {
            // remove the node from the list
            // connected previous element to to the next element;
            pre.next = node.next;
            if(node.next != null)
                node.next.prev = pre;
            node.prev = null;
        }


        addToLL(node);
    }

    public Node removeTailElement() {
        Node deleted_node = null;
        if(tail != null) {
            Node prev = tail.prev;
            prev.next = null;
            deleted_node = tail;
            tail = prev;
        }
        return deleted_node;
    }
}
class LRUCache {
    int capacity;
    int size = 0;
    LRU lru = new LRU();
    public static void main(String[] args) {
        LRUCache lru = new LRUCache();
        lru.capacity =2;
        // [1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(" lru.get(1); " + lru.get(1));
        lru.put(3,3);
        System.out.println(" lru.get(2); " + lru.get(2));
        lru.put(4,4);
        System.out.println(" lru.get(1); " + lru.get(1));
        System.out.println(" lru.get(3); " + lru.get(3));
        System.out.println(" lru.get(4); " + lru.get(4));
    }


    public int get(int key) {
        if(lru.map.containsKey(key)) {
            Node n = lru.map.get(key);
            lru.moveElementToFront(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(size == capacity) {
            // first remove the least used
            size--;
            Node last_node = lru.removeTailElement();
            lru.map.remove(last_node.key);
        }
        size++;
        Node n = new Node(value, key);
        lru.map.put(key, n);
        lru.addToLL(n);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
