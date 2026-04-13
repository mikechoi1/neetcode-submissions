class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (s.equals("-")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            }
            else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    // public int evalRecursive(Stack<String> stack) {
    //     String token = stack.pop();
    //     if (!"+-*/".contains(token)) {
    //         return Integer.parseInt(token);
    //     }
    //     int right = evalRecursive(stack);
    //     int left = evalRecursive(stack);
    //     switch(token) {
    //         case "+":
    //             return left + right;
    //         case "-":
    //             return left - right;
    //         case "*":
    //             return left * right;
    //         case "/":
    //             return left / right;
    //     }
    //     return 0;
    // }
}
