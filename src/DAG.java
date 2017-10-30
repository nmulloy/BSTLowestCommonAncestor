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
}
