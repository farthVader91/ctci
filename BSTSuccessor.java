class BSTSuccessor {
    static class Node {
	int data;
	Node parent;
	Node left;
	Node right;
	
	public Node(int data, Node parent, Node left, Node right) {
	    this.data = data;
	    this.parent = parent;
	    this.left = left;
	    this.right = right;
	}
	public Node(int data, Node parent) {
	    this(data, parent, null, null);
	}

	public Node(int data) {
	    this(data, null);
	}

	@Override
	public String toString() {
	    return String.format("Node(%s) under Parent(%s)", this.data, this.parent);
	}
    }

    static Node leftAncestor(Node node) {
	if (node.parent == null || node.parent.left == node) return node;

	return leftAncestor(node.parent);
    }

    static Node leftDescendant(Node node) {
	if (node == null) return null;
	Node res = leftDescendant(node.left);
	if (res == null) {
	    res = node;
	}
	if (node.left == null && node.right == null) return node;

	if (node.left != null) retu
    }

    static Node successor(Node node) {
	return null;
    }

    public static void main(String[] args) {
	Node root = new Node(5);
	

	Node n1 = new Node(3);
	n1.parent = root;
	root.left = n1;
	Node n11 = new Node(2);
	n1.left = n11;
	n11.parent = n1;
	Node n12 = new Node(4);
	n1.right = n12;
	n12.parent = n1;
	Node n111 = new Node(1);
	n11.left = n111;
	n111.parent = n11;

	Node n2 = new Node(7);
	root.right = n2;
	n2.parent = root;
	Node n21 = new Node(6);
	n2.left = n21;
	n21.parent = n2;
	Node n22 = new Node(9);
	n2.right = n22;
	n22.parent = n2;


    }
}
