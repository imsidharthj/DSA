import java.util.Stack;

class MinStack {
    Stack<Long> stack;
    long getMin;

    public MinStack() {
        this.stack = new Stack<Long>();
    }

    public void push(int x){
        if(stack.isEmpty()){
            stack.add(0L);
            getMin = x;
        } else {
            stack.push(x-getMin);
            if(x < getMin) getMin = x;
        }
    }

    public void pop(){
        if(stack.isEmpty()) return;

        long pop = stack.pop();

        if(pop < 0) getMin = getMin - pop;
    }

    public int top(){
        long top = stack.peek();

        if(top > 0){
            return (int) (top + getMin);
        } else {
            return (int) getMin;
        }
    }

    public int getMin(){
        return (int) getMin;
    }

    public static void main(String[] args) {
        String[] operations = {"MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"};
        int[][] values = {{}, {-2}, {0}, {-3}, {}, {}, {}, {}};

        MinStack minStack = null;
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MinStack":
                    minStack = new MinStack();
                    System.out.println("Operation: MinStack -> Output: null");
                    break;
                case "push":
                    minStack.push(values[i][0]);
                    System.out.println("Operation: push(" + values[i][0] + ") -> Output: null");
                    break;
                case "pop":
                    minStack.pop();
                    System.out.println("Operation: pop -> Output: null");
                    break;
                case "top":
                    int top = minStack.top();
                    System.out.println("Operation: top -> Output: " + top);
                    break;
                case "getMin":
                    int min = minStack.getMin();
                    System.out.println("Operation: getMin -> Output: " + min);
                    break;
            }
        }
    }
}