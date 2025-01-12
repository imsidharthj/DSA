import java.util.*;

public class Main {

    Queue < Integer > q = new LinkedList < Integer > ();
    void push(int x) {
        int size = q.size();
        q.add(x);
        for(int i = 0; i < size; i++){
            q.add(q.poll());
        }
    }

    int pop() {
        if(q.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return q.poll();
    }

    int top() {
        if(q.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Scanner in = new Scanner(System.in);

        int n = in .nextInt();
        if(n <= 0){
            System.out.println("Stack is empty");
            return;
        }
        for (int i = 0; i < n; i++) {
            obj.push( in .nextInt());
        }

        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
    }
}