package LRU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Point {
    int count;
    int key;
    int value;
    Point pre;
    Point next;

    public Point(int key, int value, int count) {
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
        this.count = count;
    }
}

public class LFUCache {
    List<Point> list = new ArrayList<>();
    Map<Integer, Point> map = new HashMap<>();
    int size = 0;
    int lenth;

    public LFUCache(int capacity) {
        lenth = capacity;
        list.add(new Point(-1, -1, 0));
    }

    public int get(int key) {
        if (lenth == 0) {
            return -1;
        }
        if (map.containsKey(key)) {
            Point node = map.get(key);
            int index = node.count + 1;
            node.count = index;
            remove(node);
            if (index >= list.size()) {
                Point head = new Point(-1, -1, index);
                list.add(head);
                head.next = node;
                node.pre = head;
            } else {
                Point head = list.get(index);
                addTail(head, node);
            }
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Point node = map.get(key);
            int index = node.count + 1;
            node.count = index;
            node.value = value;
            remove(node);
            if (index >= list.size()) {
                Point head = new Point(-1, -1, index);
                list.add(head);
                head.next = node;
                node.pre = head;
            } else {
                Point head = list.get(index);
                addTail(head, node);
            }
        } else {
            if (size < lenth) {
                Point node = new Point(key, value, 0);
                map.put(key, node);
                addTail(list.get(0), node);
                size++;
            } else {
                Point node = new Point(key, value, 0);
                for (int i = 0; i < list.size(); i++) {
                    Point head = list.get(i);
                    if (head.next != null) {
                        Point delete = head.next;
                        remove(delete);
                        map.remove(delete.key);
                        break;
                    }
                }
                addTail(list.get(0), node);
                map.put(key, node);
            }
        }
    }

    private void addTail(Point head, Point node) {
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
        node.pre = head;
    }

    private void remove(Point node) {
        Point pre = node.pre;
        Point next = node.next;
        pre.next = next;
        if (next != null) {
            next.pre = pre;
        }
        node.next = null;
        node.pre = null;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0 /* capacity (缓存容量) */);
        cache.put(0, 0);
        System.out.println(cache.get(0));


    }

}
