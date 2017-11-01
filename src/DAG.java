import java.util.ArrayList;

public class DAG {
	private static final String NEWLINE = System.getProperty("line.separator");

	private int edges;// number of edges
	ArrayList<DagNode> inGraph;// list of all the nodes in the graph

	public DAG() {// constructor for DAG
		this.edges = 0; // initializes the number of edges to zero
		inGraph = new ArrayList<DagNode>(); // creates the inGraph ArrayLsit
	}

	public boolean isEmpty() {
		return numberOfVertices() == 0;
	}

	public int numberOfVertices() {
		return inGraph.size();// the number of vertices is the number of objects
								// in the ArrayList
	}

	public int numberOfEdges() {
		return edges;// returns the number of edges in the DAG
	}

	boolean validateVertex(DagNode v) {// the DagNode must be in the the
												// inGraph list in order to be a
												// valid vertex
		return inGraph.contains(v);
	}

	public void addEdge(DagNode v, DagNode w)throws IllegalArgumentException {// in the format v points w
		if (validateVertex(v) == true && validateVertex(w) == true) {
			w.parents.add(v);
			edges++;
		}
	}


	public String output() {// prints out all the parents of the DagNodes
		if (!isEmpty()) {
			String result = "";
			for (int i = 0; i < inGraph.size(); i++) {
				result += inGraph.get(i).val + ":";
				for (int j = 0; j < inGraph.get(i).parents.size(); j++) {
					result += inGraph.get(i).parents.get(j).val + ",";
				}
				result += "\n";
			}
			return result;
		}
		return null;
	}
	
	public static void main(String[] args) {
       DAG graph = new DAG();
       
       DagNode A = new DagNode("A",graph);
       DagNode B = new DagNode("B",graph);
       DagNode C = new DagNode("C",graph);
       DagNode D = new DagNode("D",graph);
       DagNode E = new DagNode("E",graph);
       
      graph.addEdge(C,A); 
      graph.addEdge(E, C);
      graph.addEdge(D, B);
      graph.addEdge(E, D);
      
      System.out.print(graph.output());
    }
	
	
}
