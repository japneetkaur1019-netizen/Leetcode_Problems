import java.util.*;
class Solution{
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            if (!dq.isEmpty()) {
                nums[i] += Math.max(0, nums[dq.peekFirst()]);
            }
            maxSum = Math.max(maxSum, nums[i]);

            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return maxSum;
    }
}