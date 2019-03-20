import java.util.LinkedList;

//sources programiz,
public class MyGraph {
	
  public int vertex;
  public LinkedList<Integer> adjacencyList[];

	public static void main(String[] args) {
		
		int[][]arr= {{1,0,1,0},{0,1,1,0},{0,1,1,1},{1,0,0,1}};
		MyGraph graph = new MyGraph();
		graph.initialize(arr);
		
  		System.out.println(graph.isConnected(0, 1));
		System.out.println(graph.isConnected(1, 3));
		System.out.println(graph.outDegree(2));
		graph.printGraph(graph);
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
		return null;

	}

	// Return the breadth first search traversal result starting from a node
	// (node IDs are separated by spaces. Do not visit nodes that cannot be reached
	// from the
	// starting node.)
	String BFS(int id) {
		return null;

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
		if(isConnected(id1,id2) == false) {
			return -1;
		}
		return 0;
	}
	
	static void printGraph(MyGraph graph) 
    {
        for(int v = 0; v < graph.vertex; v++) 
        { 
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            for(Integer pCrawl: graph.adjacencyList[v]){ 
                System.out.print(" -> "+pCrawl); 
            } 
            System.out.println("\n"); 
        } 
    }
	
	

}


// https://www.programiz.com/dsa/graph-adjacency-list
//class Graph
//{
//    private int numVertices;
//    private LinkedList<integer> adjLists[];
//}
