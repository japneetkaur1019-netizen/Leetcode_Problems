class CustomStack {

    int[] stack;
    int top;
    int maxSize;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        this.maxSize = maxSize;
        top = -1;
    }

    public void push(int x) {
        if (top == maxSize - 1) {
            return;
        }

        stack[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }

        return stack[top--];
    }

    public void increment(int k, int val) {

        int limit = Math.min(k, top + 1);

        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */