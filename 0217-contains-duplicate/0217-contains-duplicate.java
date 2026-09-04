import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        boolean isDuplicate=false;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:map.keySet()){
            if(map.get(num)>1){
                isDuplicate=true;
            }
        }
        return isDuplicate;
    }
}