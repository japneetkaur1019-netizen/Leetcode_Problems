import java.util.*;
class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();
        dq.offerLast(0);

        for(int i=1;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<i-k){
                dq.pollFirst();
            }
            nums[i]+=nums[dq.peekFirst()];
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return nums[n-1];
    }
}