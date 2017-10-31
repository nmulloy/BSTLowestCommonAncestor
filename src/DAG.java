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

	public void addEdge(DagNode v, DagNode w) {// in the format v points w
		if (validateVertex(v) == true && validateVertex(w) == true) {
			w.parents.add(v);
			edges++;
		}
	}


	public void output() {// prints out all the parents of the DagNodes
		if (!isEmpty()) {
			for (int i = 0; i < inGraph.size(); i++) {
				System.out.print(inGraph.get(i).val + ": ");
				for (int j = 0; j < inGraph.get(i).parents.size(); j++) {
					System.out.print(inGraph.get(i).parents.get(j).val + ",");
				}
				System.out.println("");
			}
		}
	}
}
