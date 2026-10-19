import java.util.*;
class Solution {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        long MOD = 1_000_000_007L;

        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                   strength[stack.peek()] >= strength[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   strength[stack.peek()] > strength[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] =
                (prefix[i] + strength[i]) % MOD;
        }

        long[] prePrefix = new long[n + 2];

        for (int i = 0; i <= n; i++) {
            prePrefix[i + 1] =
                (prePrefix[i] + prefix[i]) % MOD;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int L = left[i];
            int R = right[i];

            long leftCount = i - L;
            long rightCount = R - i;

            long rightSum =
                (prePrefix[R + 1] -
                 prePrefix[i + 1] + MOD) % MOD;

            long leftSum =
                (prePrefix[i + 1] -
                 prePrefix[L + 1] + MOD) % MOD;

            long total =
                (leftCount * rightSum % MOD -
                 rightCount * leftSum % MOD + MOD) % MOD;

            ans = (ans + strength[i] * total) % MOD;
        }

        return (int) ans;
    }
}