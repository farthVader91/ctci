class IntersectingLL {
    static class Node {
	int data;
	Node next;
	public Node(int data, Node next) {
	    this.data = data;
	    this.next = next;
	}
	
	public Node(int data) {
	    this(data, null);
	}
	
	@Override
	public String toString() {
	    return String.format("Node(%d)", this.data);
	}
	
    }

    static Node intersect(Node h1, Node h2) {
	if (h1.next == null && h2.next == null) {
	    return h1 == h2 ? h1 : null;
	}
	if (h1.next == null) {
	    return intersect(h1, h2.next);
	}
	if (h2.next == null) {
	    return intersect(h1.next, h2);
	}

	Node intersection = intersect(h1.next, h2.next);
	if (intersection == h1.next && h1 == h2) {
	    intersection = h1;
	}

	return intersection;
    }

    public static void main(String[] args) {
	Node subList = new Node(5, new Node(3, new Node(7)));
	Node l1 = new Node(4, new Node(2, subList));
	Node l2 = new Node(1, new Node(3, new Node(5, subList)));

	System.out.println(intersect(l1, l2));
    }

}
