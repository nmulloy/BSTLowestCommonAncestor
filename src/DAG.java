import java.util.ArrayList;

public class DAG {
	private static final String NEWLINE = System.getProperty("line.separator");

	private int edges;// number of edges
	ArrayList<DagNode> inGraph;

	public DAG() {//constructor for DAG
		this.edges = 0;	//initializes the number of edges to zero
		inGraph = new ArrayList<DagNode>();	//creates the inGraph ArrayLsit
	}

	public int numberOfVertices() {
		return inGraph.size();// the number of vertices is the number of objects in the ArrayList
	}

	public int numberOfEdges() {
		return edges;//returns the number of edges in the DAG
	}

	private boolean validateVertex(DagNode v) {// the DagNode must be in the the inGraph list in order to be a valid vertex
		return inGraph.contains(v);
	}

	public void addEdge(DagNode v, DagNode w) {// in the format v points w
		if(validateVertex(v) == true && validateVertex(w) == true){
			w.parents.add(v);
			edges++;
		}
	}

	public ArrayList<DagNode> findParents(DagNode v) {//returns all adjacent nodes to the vertex
		if (validateVertex(v) == true) {
			return v.parents;
		} else {
			return null;
		}
	}

	public void output() {// prints out all the parents of the DagNodes
		for (int i = 0; i < inGraph.size(); i++) {
			System.out.print(inGraph.get(i).val + ": ");
			for (int j = 0; j < inGraph.get(i).parents.size(); j++) {
				System.out.print(inGraph.get(i).parents.get(j).val + ",");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {

		DAG graph = new DAG();
		DagNode A = new DagNode("A");
		DagNode B = new DagNode("B");
		DagNode C = new DagNode("C");
		DagNode D = new DagNode("D");
		DagNode E = new DagNode("E");

		graph.inGraph.add(A);
		graph.inGraph.add(B);
		graph.inGraph.add(C);
		graph.inGraph.add(D);
		graph.inGraph.add(E);

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
