import java.util.List;
import java.util.LinkedList;

class ListDepths {
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

    static class DepthNode {
	Node node;
	int depth;
	public DepthNode(Node node, int depth) {
	    this.node = node;
	    this.depth = depth;
	}
    }

    public static List<List<Integer>> listOfDepths(Node root) {
	LinkedList<DepthNode> q = new LinkedList<>();
	List<List<Integer>> result = new LinkedList<>();
	q.add(new DepthNode(root, 0));
	while (!q.isEmpty()) {
	    DepthNode dn = q.remove();
	    if (dn.node == null) continue;
	    List<Integer> appendTo = null;
	    if (result.size() > dn.depth) {
		appendTo = result.get(dn.depth);
	    } else {
		appendTo = new LinkedList<>();
		result.add(appendTo);
	    }
	    appendTo.add(dn.node.i);
	    q.add(new DepthNode(dn.node.left, dn.depth + 1));
	    q.add(new DepthNode(dn.node.right, dn.depth + 1));
	}
	
	return result;
    }

    public static void main(String[] args) {
	Node root = new Node(7,
		 new Node(4,
			  null,
			  new Node(5,
				   new Node(3),
				   new Node(6,
					    new Node(2), new Node(1)))),
		 new Node(10,
			  null,
			  new Node(12,
				   null,
				   new Node(14,
					    null,
					    new Node(16,
						     new Node(15),
						     null))))
		 );
	List<List<Integer>> lods = listOfDepths(root);
	lods.forEach(list -> System.out.printf("list: %s%n", list));

    }
}
