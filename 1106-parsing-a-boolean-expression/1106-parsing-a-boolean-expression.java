class Solution {
    public boolean parseBoolExpr(String expression) {

        Stack<Character> st = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == '(' || ch == ',') {
                continue;
            }

            if (ch != ')') {
                st.push(ch);
            }

            else {

                int trueCount = 0;
                int falseCount = 0;

                while (!st.isEmpty() &&
                       (st.peek() == 't' || st.peek() == 'f')) {

                    char value = st.pop();

                    if (value == 't')
                        trueCount++;
                    else
                        falseCount++;
                }

                char operator = st.pop();

                if (operator == '!') {

                    if (falseCount == 1)
                        st.push('t');
                    else
                        st.push('f');
                }

                else if (operator == '&') {

                    if (falseCount > 0)
                        st.push('f');
                    else
                        st.push('t');
                }

                else if (operator == '|') {

                    if (trueCount > 0)
                        st.push('t');
                    else
                        st.push('f');
                }
            }
        }

        return st.peek() == 't';
    }
}