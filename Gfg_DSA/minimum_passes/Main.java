import java.util.Stack;

class Main{
    public static int minPass(int n, int[] height) {
        int count = 0;
        Stack<int[]> stack = new Stack<>();
        
        for (int i = height.length - 1; i >= 0; --i) {
            int currentHeight = height[i];
            
            if (stack.isEmpty()) {
                stack.push(new int[]{currentHeight, 0});
            } else {
                int passes = 0;
                int previousPasses = 0;
                
                while (!stack.isEmpty() && stack.peek()[0] < currentHeight) {
                    passes++;
                    previousPasses = stack.peek()[1];
                    stack.pop();
                    passes = Math.max(passes, previousPasses);
                }
                
                count = Math.max(count, passes);
                stack.push(new int[]{currentHeight, passes});
            }
        }
        return count;
    }
    public static int minPassTwo(int n, int[] height) {
        int ans = 0;
        Stack<int[]> st = new Stack<>();
    
        for (int i = height.length - 1; i >= 0; --i) {
            if (st.isEmpty()) {
                st.push(new int[]{height[i], 0});
            } else {
                int c = 0;
                int d = 0;
                while (!st.isEmpty() && st.peek()[0] < height[i]) {
                    c++;
                    d = st.peek()[1];
                    st.pop();
                    c = Math.max(c, d);
                }
                ans = Math.max(ans, c);
                st.push(new int[]{height[i], c});
            }
        }
        return ans;
    }

}