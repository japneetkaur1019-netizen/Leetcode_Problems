class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxEdges=0;
        for(List<Integer> row:wall){
            int prefix=0;
            for(int i=0;i<row.size()-1;i++){
                prefix+=row.get(i);
                int count=map.getOrDefault(prefix,0)+1;
                map.put(prefix,count);
                maxEdges=Math.max(maxEdges,count);
            }
        }
        return wall.size()-maxEdges;
    }
}