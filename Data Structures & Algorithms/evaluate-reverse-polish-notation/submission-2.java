class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            stack.push(token);
        }
        return evalRecursive(stack);
    }

    public int evalRecursive(Stack<String> stack) {
        String token = stack.pop();
        if (!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }
        int right = evalRecursive(stack);
        int left = evalRecursive(stack);
        switch(token) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
        }
        return 0;
    }
}
