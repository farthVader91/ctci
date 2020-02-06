import java.lang.Math;

class CheckBalanced {
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
	    return String.format("Node(%s)", this.i);
	}
    }
    static class DepthInfo {
	boolean isBalanced;
	int depth;
	public DepthInfo(boolean isBalanced, int depth) {
	    this.isBalanced = isBalanced;
	    this.depth = depth;
	}
    }
    
    static DepthInfo checkBalancedHelper(Node n) {
	if (n == null) return new DepthInfo(true, 0);
	DepthInfo lInfo = checkBalancedHelper(n.left);
	if (lInfo.isBalanced) {
	    DepthInfo rInfo = checkBalancedHelper(n.right);
	    boolean isBalanced = Math.abs(lInfo.depth - rInfo.depth) < 2;

	    System.out.printf("%s, ldepth: %s, rdepth: %s%n", n, lInfo.depth, rInfo.depth);
	    return new DepthInfo(rInfo.isBalanced && isBalanced, Math.max(lInfo.depth, rInfo.depth) + 1);
	}
	
	return new DepthInfo(false, -1);
    }

    static boolean checkBalanced(Node root) {
	return checkBalancedHelper(root).isBalanced;
    }
    
    public static void main(String[] args) {
	Node root = new Node(1,
			     new Node(3,
				      new Node(4,
					       new Node(2),
					       null),
				      new Node(5)),
			     new Node(6));
	System.out.printf("is tree balanced: %s%n", checkBalanced(root));
	
    }
}
