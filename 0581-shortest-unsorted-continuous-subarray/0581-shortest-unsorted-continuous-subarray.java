class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;

        Stack<Integer> stack = new Stack<>();

        int left = n;
        int right = -1;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] > nums[i]) {

                left = Math.min(left, stack.pop());
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] < nums[i]) {

                right = Math.max(right, stack.pop());
            }

            stack.push(i);
        }

        if (right == -1) {
            return 0;
        }

        return right - left + 1;
    }
}