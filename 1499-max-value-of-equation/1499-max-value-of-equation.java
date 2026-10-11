import java.util.*;
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;

        for (int j = 0; j < points.length; j++) {

            int x = points[j][0];
            int y = points[j][1];

            while (!dq.isEmpty() &&
                   x - points[dq.peekFirst()][0] > k) {
                dq.pollFirst();
            }
            if (!dq.isEmpty()) {
                int i = dq.peekFirst();

                ans = Math.max(ans,
                    x + y + points[i][1] - points[i][0]);
            }
            while (!dq.isEmpty() &&
                   points[dq.peekLast()][1]
                   - points[dq.peekLast()][0] <= y - x) {
                dq.pollLast();
            }

            dq.offerLast(j);
        }

        return ans;
    }
}
