class MinStack {

    class MinPair {
        public int val;
        public int minCurrently;

        public MinPair(int val, int minCurrently) {
            this.val = val;
            this.minCurrently = minCurrently;
        }
    }

    private Stack<MinPair> minStack;
    private int min;

    public MinStack() {
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        minStack.push(new MinPair(val, min));
    }
    
    public void pop() {
        if (!minStack.isEmpty()) {
            MinPair minPair = minStack.pop();
            if (minPair.minCurrently == min) {
                if (!minStack.isEmpty()) {
                    min = minStack.peek().minCurrently;
                }
                else {
                    min = Integer.MAX_VALUE;
                }
            }
        }
    }
    
    public int top() {
        // assumes stack isn't empty
        return minStack.peek().val;
    }
    
    public int getMin() {
        // assumes min is set
        return min;
    }
}
