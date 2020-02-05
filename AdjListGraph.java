import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;

class AdjListGraph {
    static class Node {
	Object value;
	List<Node> neighbors;
	public Node(Object value) {
	    this.value = value;
	    this.neighbors = new LinkedList<>();
	}
	
	@Override
	public String toString() {
	    return String.format("Node(%s) with %d neigbors", this.value, this.neighbors.size());
	}
    }

    public static boolean bfs(Node start, Node end) {
	Set<Node> visited = new HashSet<>();
	LinkedList<Node> q = new LinkedList<>();
	q.add(start);
	while (!q.isEmpty()) {
	    Node cur = q.remove();
	    if (cur == end) return true;
	    if (visited.contains(cur)) continue;
	    for (Node neighbor: cur.neighbors) {
		q.add(neighbor);
	    }
	    visited.add(cur);
	}
	return false;
    }

    private static boolean dfs(Node cur, Node end, Set<Node> visited) {
	if (cur == end) return true;
	if (visited.contains(cur)) return false;
	visited.add(cur);
	
	for (Node neighbor: cur.neighbors) {
	    if (dfs(neighbor, end, visited)) return true;
	}
	return false;
    }

    public static boolean dfs(Node start, Node end) {
	return dfs(start, end, new HashSet<>());
    }
    
    public static void main(String[] args) {
	Node n1 = new Node(1);
	Node n2 = new Node(2);
	Node n3 = new Node(3);
	Node n4 = new Node(4);
	Node n5 = new Node(5);
	Node n6 = new Node(6);
	Node n7 = new Node(7);
	Node n8 = new Node(8);

	n1.neighbors.add(n5);
	n5.neighbors.add(n1);
	n5.neighbors.add(n2);
	n2.neighbors.add(n7);
	n7.neighbors.add(n3);
	n3.neighbors.add(n4);
	
	System.out.printf("BFS: %s is connected to %s: %s%n", n1, n4, bfs(n1, n4));
	System.out.printf("BFS: %s is connected to %s: %s%n", n1, n8, bfs(n1, n8));

	System.out.printf("DFS: %s is connected to %s: %s%n", n1, n4, dfs(n1, n4));
	System.out.printf("DFS: %s is connected to %s: %s%n", n1, n8, dfs(n1, n8));

    }
}
