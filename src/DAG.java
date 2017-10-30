import java.util.ArrayList;

public class DAG{
	private static final String NEWLINE = System.getProperty("line.separator");
	
	
	private int edges;//number of edges
	private static ArrayList<NodeInfo> inGraph;
	
	public DAG(){
		this.edges = 0;
		inGraph = new ArrayList<NodeInfo>();
		
	}
	
	public int numberOfVertices(){
		return inGraph.size();
	}
	
	public int numberOfEdges(){
		return edges;
	}
	
	private void validateVertex(int v){
		if(v < 0 || v >= inGraph.size()){
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (inGraph.size()-1));
		}
	}
	
	public void addEdge (NodeInfo v, NodeInfo w){
		v.adj.add(w);
		edges++;
	}
	
	public ArrayList<NodeInfo> findAdjacent(NodeInfo v){
		validateVertex(v.index);
		return v.adj;
	}
	
	
	public void output() {
		for(int i = 0; i < inGraph.size(); i++){
			System.out.print(inGraph.get(i).val + ": ");
				for(int j = 0; j < inGraph.get(i).adj.size(); j++){
					 System.out.print( inGraph.get(i).adj.get(j).val + ",");
				}
			System.out.println("");
		}
	}
	
	  public static void main(String[] args) {
		  
		  DAG graph = new DAG();
		  NodeInfo A = new NodeInfo("A",0);
		  NodeInfo B  = new NodeInfo("B",1);
		  NodeInfo C  = new NodeInfo("C",2);
		  NodeInfo D  = new NodeInfo("D",3);
		  NodeInfo E  = new NodeInfo("E",4);
		  
		  inGraph.add(A);
		  inGraph.add(B);
		  inGraph.add(C);
		  inGraph.add(D);
		  inGraph.add(E);
		    
		  graph.addEdge(B, A);
		  graph.addEdge(B, C);
		  graph.addEdge(A, C);
		  graph.addEdge(C, D);
		  graph.addEdge(D, E);
		  graph.addEdge(E, D);
		  graph.addEdge(A, E);
		  
		  graph.output();
	  }
}
