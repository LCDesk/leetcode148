package LRU;

import java.util.HashMap;
import java.util.Map;

//双链表和hashmap实现 lru策略
class Node {
    int value;
    int key;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }
}


public class LRUCache {
    Map<Integer, Node> map;
    int lenth;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        lenth = capacity;
        size = 0;
        head = new Node(Integer.MAX_VALUE, -1);
        tail = new Node(Integer.MAX_VALUE, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addTail(node);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addTail(node);
        } else {
            if (size < lenth) {
                Node node = new Node(key, value);
                map.put(key, node);
                addTail(node);
                size++;
            } else {
                Node node = new Node(key, value);
                map.put(key, node);
                Node delete = head.next;
                remove(delete);
                map.remove(delete.key);
                addTail(node);

            }
        }
    }


    private void addTail(Node node) {
        Node pre = tail.pre;
        pre.next = node;
        node.pre = pre;
        node.next = tail;
        tail.pre = node;
    }

    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
