import java.util.ArrayList;

public class DAG{
	private static final String NEWLINE = System.getProperty("line.separator");
	

	
	private int vertices;//number of vertices
	private int edges;//number of edges
	private ArrayList<ArrayList<NodeInfo>> adj;
	private int [] indegree; //number of vertices pointing to it

	public DAG(int vertices){
		if (vertices < 0){
			throw new IllegalArgumentException("No. of vertices must not be negative");
		}
		this.vertices = vertices;
		this.edges = 0;
		indegree = new int[vertices];
		adj = new ArrayList<ArrayList<NodeInfo>>(vertices);
		for(int i =0; i < vertices ; i++){
			ArrayList<NodeInfo> inner = new ArrayList<NodeInfo>(); 
			adj.add(inner);
		}
		
	}
	
	public int numberOfVertices(){
		return vertices;
	}
	
	public int numberOfEdges(){
		return edges;
	}
	
	private void validateVertex(int v){
		if(v < 0 || v >= vertices){
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertices-1));
		}
	}
	
	public void addEdge (int v, NodeInfo w){
		validateVertex(v);
		adj.get(v).add(w);
		edges++;
	}
	
	public ArrayList<NodeInfo> findAdjacent(int v){
		validateVertex(v);
		return adj.get(v);
	}
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(vertices + " vertices, " + edges + " edges " + NEWLINE);
		for(int v = 0; v < vertices; v++){
			s.append(String.format("%d:", v));
			for(NodeInfo w : adj.get(v)){
				s.append(w.val + ", ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
	
	  public static void main(String[] args) {
		  
		  DAG graph = new DAG(13);
		  NodeInfo A = new NodeInfo("A");
		  NodeInfo B  = new NodeInfo("B");
		  
		  graph.addEdge(4, A);
		  graph.addEdge(2, A);
		  graph.addEdge(3, A);
		  graph.addEdge(0, A);
		  graph.addEdge(2, B);
		  
		  System.out.println(graph.toString());
	  }
}
