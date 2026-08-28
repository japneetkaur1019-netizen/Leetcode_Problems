class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("C")) {
                stack.pop();
            }

            else if (op.equals("D")) {
                int last = stack.peek();
                stack.push(last * 2);
            }

            else if (op.equals("+")) {
                int last = stack.pop();
                int secondLast = stack.peek();

                int sum = last + secondLast;

                stack.push(last);
                stack.push(sum);
            }

            else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}