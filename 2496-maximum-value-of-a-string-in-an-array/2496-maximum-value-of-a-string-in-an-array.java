class Solution {
    public int maximumValue(String[] strs) {
        int max=0;
        for(String str:strs){
            boolean isNumber=true;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                    isNumber=false;
                    break;
                }
            }
            int value;
            if(isNumber){
                value=Integer.parseInt(str);
            }
            else{
                value=str.length();
            }
            max=Math.max(value,max);
        }
        return max;
    }
}