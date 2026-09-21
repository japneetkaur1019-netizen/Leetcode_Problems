class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            prev[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()
                    && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            next[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            long left = i - prev[i];
            long right = next[i] - i;

            long contribution =
                    (long) arr[i] * left * right;

            sum = (sum + contribution) % MOD;
        }

        return (int) sum;
    }
}