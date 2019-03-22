
//sources programiz, geeksforgeeks
import java.util.Iterator;
import java.util.LinkedList;

public class MyGraph {

	public int nodes; // Initialize nodes
	public LinkedList<Integer> adjacencyList[]; // Initialize adjacencyList.

	public static void main(String[] args) {

	//	int[][] arr = { { 0, 1, 0, 0, 1 }, { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } }; // Initialize adjacency matrix
		int[][] arr = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1}};
		MyGraph graph = new MyGraph(); // Initialize a MyGraph object
		graph.initialize(arr); // Pass in adjacency matrix to be converted to adjacencyList
		
		System.out.println(graph.BFS(0));
		System.out.println(graph.DFS(0));
		
		System.out.println(graph.hops(1, 1));
		System.out.println(graph.isConnected(3, 3));
		
//		System.out.println(graph.hops(0, 1) + " <-- Should be 1"); //Should be 1
//		System.out.println(graph.hops(3, 0) + " <-- Should be -1"); //Should be -1
//		System.out.println(graph.hops(2, 1) + " <-- Should be 2"); //Should be 2
//		System.out.println(graph.hops(1, 2) + " <-- Should be 1"); //Should be 1
//		System.out.println(graph.hops(0, 3) + " <-- Should be 2"); //Should be 2
//		System.out.println(graph.hops(3, 3) + " <-- Should be 0"); //Should be 3
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
		
		// Create StringBuilder that will be converted to String
		StringBuilder DBuild = new StringBuilder();

		// Create boolean for each node in list as not visited.
		boolean visited[] = new boolean[this.nodes];

		// Use recursion method to iterate through list, passing starting node, boolean array and our StringBuilder object 
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

		// Create a list to keep track of nodes
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		//Sets starting node boolean to visited and adds it to the beginning of the list
		visited[id] = true;
		list.add(id);
		
		
		while (list.size() != 0) {

			//Removes the head of the list (id) and appends it to the StringBuilder
			id = list.poll();
			BFSoutput.append(id + " ");
			
			//Creates Iterator and walks through Iterator using next() 
			Iterator<Integer> i = this.adjacencyList[id].listIterator();
			while (i.hasNext()) {
				int num = i.next();
				if (!visited[num]) {
					//Sets the node boolean to visited and adds it to the list
					visited[num] = true;
					list.add(num);
				}

			}

		}
		//Converts StringBuilder to a string and returns it
		return BFSoutput.toString();
	}

	// Return whether there is an edge from id1 to id2
	boolean isConnected(int id1, int id2) {
		//Checks if LinkedList contains() returns true or not
		if (this.adjacencyList[id1].contains(id2)) {
			return true;
		}
		return false;
	}

	// Return the out-degree number of a node
	int outDegree(int id) {
		//Checks number of elements the specified node (id) has using size() method
		return this.adjacencyList[id].size();
	}

	// Returns the minimal number of hops from node 1 to node
	// 2. If there is no path from node 1 to node 2 then return -1.
	int hops(int id1, int id2) {
		
		
		boolean visited[] = new boolean[this.nodes];
		int distance[] = new int[this.nodes];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        
        visited[id1] = true;
        distance[id1]=0;
        queue.add(id1);
        while (queue.size() != 0) {

            id1 = queue.poll();
           
            Iterator<Integer> i = this.adjacencyList[id1].listIterator();
            while (i.hasNext()) {
            	int num = i.next();
            	if(visited[num]) {
            		if(num == id2 && num == id1) {
            			return distance[id2];
            		}
            		continue;
            	}
            	distance[num]=distance[id1]+1;
                    visited[num] = true;
                    queue.add(num);
                    
                    
                
                if (num==id2) {
                	
                    return distance[id2];
                }
                
               
            }

        }

		return -1;
	}

}