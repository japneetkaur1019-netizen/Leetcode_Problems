import java.util.*;
class Solution {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums)-sumMin(nums);
    }
    private long sumMin(int[] nums){
        int n=nums.length;
        long sum=0;

        int[] prev=new int[n];
        int[] next=new int[n];

        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            prev[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
         for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            sum += (long) nums[i] * left * right;
        }

        return sum;
    }
    private long sumMax(int[] nums) {
        int n = nums.length;
        long sum = 0;

        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            sum += (long) nums[i] * left * right;
        }

        return sum;
    }
}