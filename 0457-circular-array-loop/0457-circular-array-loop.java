class Solution {

    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            boolean direction = nums[i] > 0;

            int slow = i;
            int fast = i;

            while (true) {

                int nextSlow = getNext(nums, slow);

                if ((nums[nextSlow] > 0) != direction) {
                    break;
                }

                int nextFast = getNext(nums, fast);

                if ((nums[nextFast] > 0) != direction) {
                    break;
                }

                nextFast = getNext(nums, nextFast);

                if ((nums[nextFast] > 0) != direction) {
                    break;
                }

                slow = nextSlow;
                fast = nextFast;

                if (slow == fast) {

                    if (slow == getNext(nums, slow)) {
                        break;
                    }

                    return true;
                }
            }
        }

        return false;
    }

    private int getNext(int[] nums, int i) {
        int n = nums.length;

        return ((i + nums[i]) % n + n) % n;
    }
}