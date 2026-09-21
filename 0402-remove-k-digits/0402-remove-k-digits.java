class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char ch : num.toCharArray()) {

            while (!stack.isEmpty()
                    && k > 0
                    && stack.peek() > ch) {

                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();
        int i = 0;

        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String ans = sb.substring(i);

        return ans.length() == 0 ? "0" : ans;
    }
}