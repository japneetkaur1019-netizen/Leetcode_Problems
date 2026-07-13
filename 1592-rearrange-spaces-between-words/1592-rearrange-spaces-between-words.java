class Solution {
    public String reorderSpaces(String text) {
        int spaces=0;
        for(char ch:text.toCharArray()){
            if(ch==' '){
                spaces++;
            }
        }
        String[] words=text.trim().split("\\s+");
        if(words.length==1){
            return words[0]+" ".repeat(spaces);
        }
        int gap = spaces / (words.length - 1);
        int extra = spaces % (words.length - 1);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<words.length;i++){
            ans.append(words[i]);
            if (i != words.length - 1) {
                ans.append(" ".repeat(gap));
            }
        }
        ans.append(" ".repeat(extra));

        return ans.toString();
    }
}