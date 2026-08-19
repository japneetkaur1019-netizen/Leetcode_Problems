/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if (head == null) {
            return head;
        }

        flattenList(head);

        return head;
    }

    private Node flattenList(Node curr) {

        Node node = curr;
        Node last = curr;

        while (node != null) {

            Node next = node.next;

            if (node.child != null) {

                Node child = node.child;

                Node childTail = flattenList(child);

                node.next = child;
                child.prev = node;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                node.child = null;

                last = childTail;

            } else {
                last = node;
            }

            node = next;
        }

        return last;
    }
}