import java.util.Iterator;
import java.util.LinkedList;

//sources programiz, geeksforgeeks
public class MyGraph {
	
  public int vertex;
  public LinkedList<Integer> adjacencyList[];

	public static void main(String[] args) {
		
		int[][]arr= {{0,1,1,0},{0,0,0,0},{1,0,0,1},{0,0,0,1}};
		MyGraph graph = new MyGraph();
		graph.initialize(arr);
		
//  		System.out.println(graph.isConnected(0, 1));
//		System.out.println(graph.isConnected(1, 3));
//		System.out.println(graph.outDegree(2));
//		System.out.println(graph.hops(3, 1));
//		graph.printGraph(graph);
		System.out.println(graph.DFS(2));
	}

// This method will construct a graph based on
// an adjacency matrix input. 
// Note that the matrix will be a bitmap (0 or 1).
	void initialize(int[][] adjacencyMatrix) {
		
		this.vertex = adjacencyMatrix.length;
		System.out.println("Vertex value is: " + this.vertex);
        adjacencyList = new LinkedList[this.vertex];
        for (int i = 0; i < this.vertex; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        
        for (int x = 0; x < adjacencyMatrix.length; x++) {

            for (int y = 0; y < adjacencyMatrix[x].length; y++) {

                if (adjacencyMatrix[x][y] == 1) {
                    this.adjacencyList[x].add(y);
                }

            }

        }
        
	}

	// Return the depth first search traversal result starting from a node
	// (node IDs are separated by spaces. Do not visit nodes that cannot be reached
	// from the
	// starting node.)
	String DFS(int id) { 
        // Mark all the vertices as not visited(By default 
        // set as false)
		StringBuilder DFSoutput = new StringBuilder();
        boolean visited[] = new boolean[this.vertex]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[id]=true; 
        queue.add(id); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            id = queue.poll();
            DFSoutput.append(id + " ");
            System.out.print(id+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = this.adjacencyList[id].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        }
        return DFSoutput.toString();
    }

	// Return the breadth first search traversal result starting from a node
	// (node IDs are separated by spaces. Do not visit nodes that cannot be reached
	// from the
	// starting node.)
	String BFS(int id) {
		StringBuilder BFSoutput = new StringBuilder();
        boolean visited[] = new boolean[this.vertex];

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
		
		if(this.adjacencyList[id1].contains(id2)) {
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

        boolean visited[] = new boolean[this.vertex];
        int distance[] = new int[this.vertex];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[id1] = true;
        distance[id1] = 0;
        queue.add(id1);

        while (queue.size() != 0) {

            int x = queue.pop();

            // Iterator<Integer> i = this.adjacencyList[id1].listIterator();
            for (int i = 0; i < this.adjacencyList[x].size(); i++) {
                // int num = i.next();
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

//static void printGraph(MyGraph graph) 
//{
//    for(int v = 0; v < graph.vertex; v++) 
//    { 
//        System.out.println("Adjacency list of vertex "+ v); 
//        System.out.print("head"); 
//        for(Integer pCrawl: graph.adjacencyList[v]){ 
//            System.out.print(" -> "+pCrawl); 
//        } 
//        System.out.println("\n"); 
//    } 
//}




// https://www.programiz.com/dsa/graph-adjacency-list
//class Graph
//{
//    private int numVertices;
//    private LinkedList<integer> adjLists[];
//}
