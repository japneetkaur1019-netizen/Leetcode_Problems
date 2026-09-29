class Solution {
    public long maximumSumOfHeights(int[] maxHeights) {

        int n = maxHeights.length;
        long ans = 0;

        for (int peak = 0; peak < n; peak++) {

            long sum = maxHeights[peak];

            int height = maxHeights[peak];

            for (int j = peak - 1; j >= 0; j--) {
                height = Math.min(height, maxHeights[j]);
                sum += height;
            }

            height = maxHeights[peak];

            for (int j = peak + 1; j < n; j++) {
                height = Math.min(height, maxHeights[j]);
                sum += height;
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}