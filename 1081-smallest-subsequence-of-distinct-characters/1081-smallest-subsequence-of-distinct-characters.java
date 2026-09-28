class Solution {
    public String smallestSubsequence(String s) {

        int n = s.length();

        int[] last = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (visited[ch - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && last[stack.peek() - 'a'] > i) {

                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}