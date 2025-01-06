import java.util.Stack;

class Main{
    public String minRemoveToMakeValid(String s){
        StringBuilder str = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(str.charAt(i) == '('){
                stack.add(i);
            } else if(str.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    str.setCharAt(i, '*');
                }
            }
        }

        while(!stack.isEmpty()){
            str.setCharAt(stack.pop(), '*');
        }
        System.out.println(str);
        return str.toString().replace("*", "");
    }

    public static void main(String[] args) {
        Main solution = new Main();

        String input = "a)b(c)d)";
        System.out.println("Input: " + input);

        String result = solution.minRemoveToMakeValid(input);
        System.out.println("Output: " + result);
    }
}