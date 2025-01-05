import java.util.*;

class ListNode {
    char val;
    ListNode prev;
    ListNode next;

    ListNode(char val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            ListNode newNode = new ListNode(ch);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Character> stack = new Stack<>();
        ListNode current = head;
        while(current != null){
            stack.push(current.val);
            current = current.next;
        }
        
        ListNode temp = head;
        while(temp != null){
            int stackValue = stack.pop();
            if(temp.val != stackValue){
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}