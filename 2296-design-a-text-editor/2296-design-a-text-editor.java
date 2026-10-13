import java.util.*;
class TextEditor {

    Stack<Character> left;
    Stack<Character> right;

    public TextEditor() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void addText(String text) {
        for (char ch : text.toCharArray()) {
            left.push(ch);
        }
    }

    public int deleteText(int k) {
        int count = 0;

        while (k > 0 && !left.isEmpty()) {
            left.pop();
            count++;
            k--;
        }

        return count;
    }

    public String cursorLeft(int k) {
        while (k > 0 && !left.isEmpty()) {
            right.push(left.pop());
            k--;
        }

        return getLast10();
    }

    public String cursorRight(int k) {
        while (k > 0 && !right.isEmpty()) {
            left.push(right.pop());
            k--;
        }

        return getLast10();
    }

    private String getLast10() {
        StringBuilder sb = new StringBuilder();

        int start = Math.max(0, left.size() - 10);

        for (int i = start; i < left.size(); i++) {
            sb.append(left.get(i));
        }

        return sb.toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */