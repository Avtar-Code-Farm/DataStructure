package FacebookProblems.Easy;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;

        ListNode[] lists = new ListNode[3];
        lists[0] = a;

        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        c.next = d;
        ListNode e = new ListNode(5);
        d.next = e;
        lists[1] = c;

        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);
        f.next = g;
        ListNode h = new ListNode(7);
        g.next = h;
        ListNode i = new ListNode(8);
        h.next = i;
        lists[2] = f;

        ListNode res = GetMergeKSortedList(lists);
    }

    private static ListNode GetMergeKSortedList(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        //PriorityQueue<Data> pq = new PriorityQueue<>((Comparator.comparing(Data::ListNode::val)));
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        ListNode head = null;

        for(int i  = 0 ; i < lists.length; i++) {
            pq.add(lists[i]);
        }

        ListNode temp = null;
        while(!pq.isEmpty()) {
            // pull element from the pq
            ListNode cur_data = pq.poll();
            if(head == null) {
                head = cur_data;
                temp = head;
            } else {
                temp.next = cur_data;
                temp = temp.next;
            }

            // add element into the pq
            if(cur_data.next != null) {
                pq.add(cur_data.next);
            }
        }


        return head;
    }
}
