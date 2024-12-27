import java.util.HashMap;

class Node{
    int key;
    int data;
    Node next;
    Node prev;

    Node(int data, int key){
        this.data = data;
        this.key = key;
    }
}
class LRUChache{
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int count;
    private int capacity;

    public LRUChache(int capacity) {
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key){
        if(map.get(key) != null){
            Node temp = map.get(key);
            int res = temp.data;

            deleteNode(temp);
            updateNode(temp);
            return res;
        }
        return -1;
    }

    public void put(int key, int data){
        if(map.get(key) != null){
            Node temp = map.get(key);
            temp.data = data;
            deleteNode(temp);
            updateNode(temp);
        } else { 
            Node temp = new Node(key, data);
            map.put(key, temp);
            if(count < capacity){
                count += 1;
                updateNode(temp);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                updateNode(temp);
            }
        }
    }

    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void updateNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
public class Main {
    public static void main(String[] args) {
        LRUChache cache = new LRUChache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // Returns 1
        cache.put(3, 3); // Evicts key 2
        System.out.println(cache.get(2)); // Returns -1 (not found)
        cache.put(4, 4); // Evicts key 1
        System.out.println(cache.get(1)); // Returns -1 (not found)
        System.out.println(cache.get(3)); // Returns 3
        System.out.println(cache.get(4)); // Returns 4
    }
}