import java.util.*;

class FrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    private void balance() {

        if (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }

        else if (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {

        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }

        left.addLast(val);
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {

        if (left.isEmpty()) {
            return -1;
        }

        int ans = left.removeFirst();
        balance();

        return ans;
    }

    public int popMiddle() {

        if (left.isEmpty()) {
            return -1;
        }

        int ans = left.removeLast();
        balance();

        return ans;
    }

    public int popBack() {

        if (left.isEmpty()) {
            return -1;
        }

        int ans;

        if (!right.isEmpty()) {
            ans = right.removeLast();
        } else {
            ans = left.removeLast();
        }

        balance();

        return ans;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */