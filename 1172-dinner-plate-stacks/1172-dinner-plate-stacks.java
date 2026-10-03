class DinnerPlates {

    private int capacity;
    private List<Stack<Integer>> stacks;
    private PriorityQueue<Integer> available;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        available = new PriorityQueue<>();
    }

    public void push(int val) {

        while (!available.isEmpty() &&
               (available.peek() >= stacks.size() ||
                stacks.get(available.peek()).size() == capacity)) {
            available.poll();
        }

        if (available.isEmpty()) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(val);

            stacks.add(newStack);

            if (capacity > 1) {
                available.offer(stacks.size() - 1);
            }
        } else {

            int index = available.peek();

            stacks.get(index).push(val);

            if (stacks.get(index).size() == capacity) {
                available.poll();
            }
        }
    }

    public int pop() {

        while (!stacks.isEmpty() &&
               stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        if (stacks.isEmpty()) {
            return -1;
        }

        int index = stacks.size() - 1;

        int value = stacks.get(index).pop();

        available.offer(index);

        while (!stacks.isEmpty() &&
               stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return value;
    }

    public int popAtStack(int index) {

        if (index >= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }

        int value = stacks.get(index).pop();

        available.offer(index);

        return value;
    }
}
/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */