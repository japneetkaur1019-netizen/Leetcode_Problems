class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack=new Stack<>();

        stack.push(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] current=intervals[i];
            int[] top=stack.peek();

            if(current[0]<=top[1]){
                top[1]=Math.max(top[1],current[1]);
            }
            else{
                stack.push(current);
            }
        }
        int[][] result=new int[stack.size()][2];

        for(int i=stack.size()-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }
}