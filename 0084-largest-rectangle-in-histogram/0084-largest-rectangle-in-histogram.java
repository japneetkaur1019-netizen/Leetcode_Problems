import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] > heights[i]) {

                int index = stack.pop();

                int height = heights[index];

                int nse = i;

                int pse = stack.isEmpty() ? -1 : stack.peek();

                int width = nse - pse - 1;

                maxArea = Math.max(
                    maxArea,
                    height * width
                );
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {

            int index = stack.pop();

            int height = heights[index];

            int nse = n;

            int pse = stack.isEmpty() ? -1 : stack.peek();

            int width = nse - pse - 1;

            maxArea = Math.max(
                maxArea,
                height * width
            );
        }

        return maxArea;
    }
}