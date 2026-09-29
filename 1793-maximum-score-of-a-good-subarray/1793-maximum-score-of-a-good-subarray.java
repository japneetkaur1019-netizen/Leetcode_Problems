import java.util.*;

class Solution {
    public int maximumScore(int[] nums, int k) {

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int start = left[i] + 1;
            int end = right[i] - 1;

            if (start <= k && k <= end) {

                int width = right[i] - left[i] - 1;

                int score = nums[i] * width;

                ans = Math.max(ans, score);
            }
        }

        return ans;
    }
}