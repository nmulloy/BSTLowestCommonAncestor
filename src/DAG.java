import java.util.ArrayList;

public class DAG{
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private int vertices;//number of vertices
	private int edges;//number of edges
	private ArrayList<ArrayList<Integer>> adj;
	private int [] indegree; //number of vertices pointing to it

	public DAG(int vertices){
		if (vertices < 0){
			throw new IllegalArgumentException("No. of vertices must not be negative");
		}
		this.vertices = vertices;
		this.edges = 0;
		indegree = new int[vertices];
		adj = new ArrayList<ArrayList<Integer>>(vertices);
		for(int i =0; i < vertices ; i++){
			ArrayList<Integer> inner = new ArrayList<Integer>(); 
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
	
	public void addEdge (int v, int w){
		validateVertex(v);
		validateVertex(w);
		adj.get(v).add(w);
		indegree[w]++;
		edges++;
	}
	
	public ArrayList<Integer> findAdjacent(int v){
		validateVertex(v);
		return adj.get(v);
	}
	
	public int outdegree(int v){
		validateVertex(v);
		return adj.get(v).size();
	}
	
	public int indegree(int v){
		validateVertex(v);
		return indegree[v];
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(vertices + " vertices, " + edges + " edges " + NEWLINE);
		for(int v = 0; v < vertices; v++){
			s.append(String.format("%d:", v));
			for(int w : adj.get(v)){
				s.append(String.format(" %d,", w));
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}
	
	  public static void main(String[] args) {
		  DAG graph = new DAG(5);
		  graph.addEdge(3, 2);
		  graph.addEdge(4, 2);
		  graph.addEdge(1, 3);
		  graph.addEdge(0, 2);
		  graph.addEdge(1, 2);
		  graph.addEdge(2, 1);
		  graph.addEdge(3, 4);
		  System.out.println(graph.toString());
	  }
}
