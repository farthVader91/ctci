import java.util.NoSuchElementException;
class SortedStack {
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
    static class Stack {
	Node top;
	public boolean isEmpty() {
	    return top == null;
	}
	public void push(int data) {
	    Node node = new Node(data);
	    node.next = top;
	    top = node;
	}
	public int peek() {
	    if (top == null) {
		throw new NoSuchElementException("stack is empty");
	    }
	    return top.data;
	}
	public int pop() {
	    if (top == null) {
		throw new NoSuchElementException("stack is empty");
	    }
	    int data = top.data;
	    top = top.next;

	    return data;
	}
    }
    Node top;
    Stack buffer = new Stack();
    public void push(int data) {
	if (top == null) {
	    _push(data);
	    return;
	}
	
	while(!isEmpty() && peek() > data) {
	    buffer.push(pop());
	}
	_push(data);
	while(!buffer.isEmpty()) {
	    _push(buffer.pop());
	}
    }
    private void _push(int data) {
	Node node = new Node(data, top);
	top = node;
    }
    
    public int peek() {
	if (top == null) {
	    throw new NoSuchElementException("stack is empty");
	}

	return top.data;
    }
    public int pop() {
	if (top == null) {
	    throw new NoSuchElementException("stack is empty");
	}
	int data = top.data;
	top = top.next;

	return data;
    }
    public boolean isEmpty() {
	return top == null;
    }

    public static void main(String[] args) {
	SortedStack ss = new SortedStack();
	ss.push(34);
	ss.push(42);
	ss.push(16);
	ss.push(24);
	ss.push(12);
	ss.push(3);
	while (!ss.isEmpty()) {
	    System.out.println(ss.pop());
	}
    }
}
