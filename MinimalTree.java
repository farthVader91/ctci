import java.lang.Math;

class MinimalTree {
    static class Node {
	int i;
	Node left;
	Node right;
	public Node(int i, Node left, Node right) {
	    this.i = i;
	    this.left = left;
	    this.right = right;
	}


	public Node(int i) {
	    this(i, null, null);
	}

	@Override
	public String toString() {
	    return String.format("Node(%d)", this.i);
	}
    }

    static Node minimalTree(int[] input, int start, int end) {
	Node root = null;
	if (start == end) {
	    return new Node(input[start]);
	}
	
	int mid = (end + start) / 2;
	int rem = (end + start) % 2;
	if (rem == 1) {
	    // implies evenly divided; so build tree for both halves and nest either below the other;
	    root = minimalTree(input, start, Math.max(mid - 1, start));
	    root.right = minimalTree(input, Math.min(mid + 1, end), end);
	} else {
	    root = new Node(input[mid]);
	    root.left = minimalTree(input, start, Math.max(mid - 1, start));
	    root.right = minimalTree(input, Math.min(mid + 1, end), end);
	}

	return root;
    }

    static Node minimalTree(int[] input) {
	return minimalTree(input, 0, input.length - 1);
    }

    public static void main(String[] args) {
	int[] arr = new int[]{ 1, 3, 5, 7, 9};
	Node root = minimalTree(arr);
	System.out.printf("root.right.right == %s%n", root.right.right);
	System.out.printf("root.left.right == %s%n", root.left.right);
    }

}
