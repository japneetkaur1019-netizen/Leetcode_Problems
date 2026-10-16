import java.util.*;
class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1.0);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {

            int pos = cars[i][0];
            int speed = cars[i][1];

            while (!stack.isEmpty()) {
                int j = stack.peek();

                int nextPos = cars[j][0];
                int nextSpeed = cars[j][1];

                if (speed <= nextSpeed) {
                    stack.pop();
                    continue;
                }

                double time = (double)(nextPos - pos)
                                    / (speed - nextSpeed);

                if (ans[j] != -1.0 && time > ans[j]) {
                    stack.pop();
                } else {
                    ans[i] = time;
                    break;
                }
            }

            stack.push(i);
        }

        return ans;
    }
}