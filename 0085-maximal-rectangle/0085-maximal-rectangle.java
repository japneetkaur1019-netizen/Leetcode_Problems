import java.util.*;

class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] heights = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(
                maxArea,
                largestRectangleArea(heights)
            );
        }

        return maxArea;
    }


    private int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   heights[stack.peek()] > heights[i]) {

                int index = stack.pop();

                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();

                int area =
                    heights[index] * (nse - pse - 1);

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {

            int index = stack.pop();

            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();

            int area =
                heights[index] * (nse - pse - 1);

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}