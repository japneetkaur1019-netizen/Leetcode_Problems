class Solution {
    public int calculate(String s) {
        Stack<Integer> stack= new Stack<>();
        int number=0;
        char sign='+';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                number=number*10+(ch-'0');
            }
            if((!Character.isDigit(ch) && ch!=' ')|| i==s.length()-1){
                if(sign=='+'){
                    stack.push(number);
                }
                else if(sign=='-'){
                    stack.push(-number);
                }
                else if(sign=='*'){
                    int previous=stack.pop();
                    stack.push(previous*number);
                }
                else if(sign=='/'){
                    int previous=stack.pop();
                    stack.push(previous/number);
                }
                sign=ch;
                number=0;
            }
        }
        int result=0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}