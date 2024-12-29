import java.util.Stack;

class Main{
    public int calculate(String s){
        if(s == null || s.length() == 0) return 0;

        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for(int i = 0; i < len; i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1){
                if(operation == '-'){
                    stack.push(-currentNumber);
                } else if(operation == '+'){
                    stack.push(currentNumber);
                } else if(operation == '*'){
                    stack.push(stack.pop() * currentNumber);
                } else if(operation == '/'){
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Main calculator = new Main();

        String expression1 = "3+2*2";
        String expression2 = " 3/2 ";
        String expression3 = " 3+5 / 2 ";

        System.out.println("Expression: " + expression1 + " = " + calculator.calculate(expression1));
        System.out.println("Expression: " + expression2 + " = " + calculator.calculate(expression2));
        System.out.println("Expression: " + expression3 + " = " + calculator.calculate(expression3));
    }
}