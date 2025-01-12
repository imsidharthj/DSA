import java.util.*;

class Main {
    public static void findDuplicateParenthesis(String inputString) {
        Stack<Character> stack=new Stack<>();
        // for (char ch : inputString.toCharArray()) {
        //     if (ch == ')') {
        //         if (stack.peek() == '(') {
        //             return "Input string contains duplicate parenthesis";
        //         } else {
        //             while (!stack.isEmpty() && stack.peek() != '(') {
        //                 stack.pop();
        //             }
        //             stack.pop();
        //         }
        //     } else {
        //         stack.push(ch);
        //     }
        // }
        // return "Input string does not contain duplicate parenthesis";
        for(int i = 0; i<inputString.length(); i++){
            char c = inputString.charAt(i);
            if(c != ')'){
                stack.push(c);
            } else {
                char top = stack.peek();
                stack.pop();
                int count = 0;
                while(top != '('){
                    top=stack.peek();
                    stack.pop();
                    count++;
                }
                if(count < 1){
                    System.out.println("Input string contains duplicate parenthesis");
                    return;
                }
            }
        }
        System.out.println("Input string does not contain duplicate parenthesis");
    }

    public static void main(String[] args){
        // Main obj = new Main();
        // String inputString = new String();
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();
        findDuplicateParenthesis(inputString);
    }

}