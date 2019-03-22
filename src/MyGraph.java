
//sources programiz, geeksforgeeks
import java.util.Iterator;
import java.util.LinkedList;

public class MyGraph {

	public int nodes; // Initialize nodes
	public LinkedList<Integer> adjacencyList[]; // Initialize adjacencyList.

	public static void main(String[] args) {

		int[][] arr = { { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 0, 1 }, { 1, 0, 1, 1 } }; // Initialize
																											// adjacency
																											// matrix
		MyGraph graph = new MyGraph(); // Initialize a MyGraph object
		graph.initialize(arr); // Pass in adjacency matrix to be converted to adjacencyList

	}

	@SuppressWarnings("unchecked")
// This method will construct a graph based on
// an adjacency matrix input. 
// Note that the matrix will be a bitmap (0 or 1).
	void initialize(int[][] adjacencyMatrix) {

		this.nodes = adjacencyMatrix.length; // Number of nodes will be set to the length of the adjacencyMatrix
		adjacencyList = new LinkedList[this.nodes]; // Use LinkedList as data structure for adjacencyList
		for (int i = 0; i < this.nodes; i++) {
			adjacencyList[i] = new LinkedList<>(); // Create LinkedList for each node
		}

// The double for loop adds the correct values to the adjacencyList in the form of a bitmap (0 or 1).  
		for (int x = 0; x < adjacencyMatrix.length; x++) {

			for (int y = 0; y < adjacencyMatrix[x].length; y++) {

				if (adjacencyMatrix[x][y] == 1) {
					this.adjacencyList[x].add(y);
				}

			}

		}

	}

	// Recursive part of DFS. The recursion is required since we have check for every node
	void recurrsiveDFSPart(int subid, boolean visited[], StringBuilder subDBuild) {

		// Set the boolean to true since we are well... visiting it.
		visited[subid] = true;
		
		// Because we have visited the node, we add it to the StringBuilder list
		subDBuild.append(subid + " ");

		// Check for all nodes in the adjacencyList. This requires calling itself if it has not visited the node
		Iterator<Integer> i = this.adjacencyList[subid].listIterator();
		while (i.hasNext()) {
			int numero = i.next();
			if (!visited[numero])
				recurrsiveDFSPart(numero, visited, subDBuild);
		}
	}

	// Return the depth first search traversal result starting from a node
	// (node IDs are separated by spaces. Do not visit nodes that cannot be reached
	// from the
	// starting node.)
	String DFS(int id) {
		StringBuilder DBuild = new StringBuilder();

		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[this.nodes];

		// Call the recursive helper function to print DFS traversal
		recurrsiveDFSPart(id, visited, DBuild);

		return DBuild.toString();
	}

	// Return the breadth first search traversal result starting from a node
	// (node IDs are separated by spaces. Do not visit nodes that cannot be reached
	// from the
	// starting node.)
	String BFS(int id) {

		// Use stringBuilder that can be concatenated onto
		StringBuilder BFSoutput = new StringBuilder();

		// Use booleans to check if node has been visited or not. (all set to false)
		boolean visited[] = new boolean[this.nodes];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[id] = true;
		queue.add(id);

		while (queue.size() != 0) {

			id = queue.poll();
			BFSoutput.append(id + " ");

			Iterator<Integer> i = this.adjacencyList[id].listIterator();
			while (i.hasNext()) {
				int num = i.next();
				if (!visited[num]) {
					visited[num] = true;
					queue.add(num);
				}

			}

		}

		return BFSoutput.toString();
	}

	// Return whether there is an edge from id1 to id2
	boolean isConnected(int id1, int id2) {

		if (this.adjacencyList[id1].contains(id2)) {
			return true;
		}
		return false;
	}

	// Return the out-degree number of a node
	int outDegree(int id) {
		return this.adjacencyList[id].size();
	}

	// Returns the minimal number of hops from node 1 to node
	// 2. If there is no path from node 1 to node 2 then return -1.
	int hops(int id1, int id2) {

		boolean visited[] = new boolean[this.nodes];
		int distance[] = new int[this.nodes];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[id1] = true;
		distance[id1] = 0;
		queue.add(id1);

		while (queue.size() != 0) {

			int x = queue.pop();

			for (int i = 0; i < this.adjacencyList[x].size(); i++) {
				if (visited[adjacencyList[x].get(i)]) {
					continue;
				}
				distance[adjacencyList[x].get(i)] = distance[x] + 1;
				visited[adjacencyList[x].get(i)] = true;
				queue.add(adjacencyList[x].get(i));
				if (adjacencyList[x].get(i) == id2) {
					return distance[id2];
				}
			}

		}

		return -1;
	}

}