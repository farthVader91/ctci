class PalindromeLL {
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

    static class Tracker {
	bool hasMatched;
	Node mirror;
    }

    static int length(Node head) {
	if (head == null) return 0;
	return 1 + length(head.next);
    }

    static bool isPalindrome(Node head) {
	int n = length(head);
	int mid = n / 2;
    }
    
    public static void main(String[] args) {
	Node list1 = new Node(1, new Node(3, new Node(5, new Node(3, new Node(1)))));
	

    }
}
