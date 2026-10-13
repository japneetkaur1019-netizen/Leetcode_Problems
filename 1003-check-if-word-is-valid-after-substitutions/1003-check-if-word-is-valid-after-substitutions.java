import java.util.*;
class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == 'c' && st.size() >= 2) {

                char b = st.pop();
                char a = st.pop();

                if (a == 'a' && b == 'b') {
                    continue;
                }

                st.push(a);
                st.push(b);
            }

            st.push(ch);
        }

        return st.isEmpty();
    }
}