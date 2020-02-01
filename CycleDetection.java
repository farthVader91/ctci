import java.io.IOException;
class CycleDetection {
    static class Node {
	int data;
	Node next;
	public Node(int data, Node next) {
	    this.data = data;
	    this.next = next;
	}
	public Node(int data) {
	    this.data = data;
	    this.next = null;
	}
	@Override
	public String toString() {
	    return String.format("Node(%d)", this.data);
	}
    }

    static Node collissionPoint(Node head) throws IOException {
	Node slow = head;
	Node fast = head;
	while(fast != null) {
	    System.out.println("Slow: " + slow + ", Fast: " + fast);
	    slow = slow.next;
	    fast = fast.next.next;
	    System.in.read();
	    if (slow == fast) break;
	}
	System.out.println("slow and fast are: " + slow + ", " + fast );
	return fast;
    }

    static Node loopHead(Node head) throws IOException {
	Node ptr1 = head;
	Node ptr2 = collissionPoint(head);
	System.out.println("coll point " + ptr2);
	if (ptr2 == null) return null;
	// move 2 pointers one from head, other from coll. point at same pace
	while(ptr1 != ptr2) {
	    ptr1 = ptr1.next;
	    ptr2 = ptr2.next;
	}
	return ptr1;
	
    }

    public static void main(String[] args) throws IOException {
	Node loopHead = new Node(0);
	loopHead.next = new Node(1, new Node(3, new Node(5, loopHead)));
	Node list = new Node(4, new Node(2));

	System.out.println("Loop head is: " + loopHead(list));
    }
}
