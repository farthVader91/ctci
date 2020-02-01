public class LinkedList {
    static class Node {
	int data;
	Node nxt;
        @Override
	public String toString() {
	    return "Node(" + this.data + ")";
	}
    }

    static Node reverseLL(Node head) {
	if (head.nxt == null) {
	    return head;
	}
	Node tail = reverseLL(head.nxt);
	head.nxt = null;
	tail.nxt = head;
	return null;
    }

    static int length(Node head) {
	if (head == null) return 0;
	return 1 + length(head.nxt);
    }

    static class SumResult {
	Node sumHead;
	int carry;
    }

    static Node sumHelper(Node head1, Node head2, int carry) {
	if (head1 == null && head2 == null) {
	    return null;
	}
	if (head1 == null) {
	    head1 = new Node();
	    head1.data = 0;
	}
	if (head2 == null) {
	    head2 = new Node();
	    head2.data = 0;
	}
	// TODO: handle corner case where either elements can be null
	int sum = head1.data + head2.data + carry;
	Node sumNode = new Node();
	sumNode.data = sum % 10;
	sumNode.nxt = sumHelper(head1.nxt, head2.nxt, sum / 10);
	return sumNode;
    }

    static Node sumAscLL(Node head1, Node head2) {
	return sumHelper(head1, head2, 0);
    }

    static String llToString(Node head) {
	if (head == null) return "";
	return head.data + ", "+ llToString(head.nxt);
    }

    public static void main(String[] args) {
	Node l1n1 = new Node();
	l1n1.data = 7;
	Node l1n2 = new Node();
	l1n2.data = 1;
	Node l1n3 = new Node();
	l1n3.data = 6;

	l1n1.nxt = l1n2;
	l1n2.nxt = l1n3;
	
	Node l2n1 = new Node();
	l2n1.data = 5;
	Node l2n2 = new Node();
	l2n2.data = 9;
	Node l2n3 = new Node();
	l2n3.data = 2;
	Node l2n4 = new Node();
	l2n4.data = 9;

	l2n1.nxt = l2n2;
	l2n2.nxt = l2n3;
	l2n3.nxt = l2n4;

	System.out.println(llToString(l1n1));
	System.out.println(llToString(l2n1));

	System.out.println(llToString(sumAscLL(l1n1, l2n1)));
	
    }
}
