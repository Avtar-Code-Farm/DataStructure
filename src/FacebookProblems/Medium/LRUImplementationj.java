package FacebookProblems.Medium;

import java.util.HashMap;
import java.util.LinkedList;

class Cache
{
    int key;
    char value;
    Cache(int key, char value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUImplementationj {

    // map to find get the data with O(1)
    static HashMap<Integer, Cache> map = new HashMap<>();
    // linkList to make LRU info available in O(1)
    static LinkedList<Integer> linkedList = new LinkedList<>();

    static int capacity = 2;

    public static void main(String[] args) {
        put(1,'a');
        put(2,'b');
        char ch = get(1);
        put(3,'c');
        ch = get(2);
        put(4,'d');
        ch = get(1);
        ch = get(3);
        ch = get(4);
    }

    static void put(int key, char value) {
        // add key to the map and then add the key to the top of the linkedlist
        Cache data = new Cache(key, value);
        map.put(key, data);
        linkedList.addFirst(key);

        if(linkedList.size() > capacity) {
            int remove_item_key = linkedList.getLast();
            map.remove(remove_item_key);

            linkedList.remove(remove_item_key);
        }
    }

    static char get(int key) {
        if(!map.containsKey(key)) return '&';
        Cache item = map.get(key);

        linkedList.remove(item.key);

        linkedList.addFirst(item.key);
        return item.value;
    }
}
