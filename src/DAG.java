import java.util.ArrayList;

public class DAG {
	private static final String NEWLINE = System.getProperty("line.separator");

	private int edges;// number of edges
	ArrayList<DagNode> inGraph;

	public DAG() {
		this.edges = 0;
		inGraph = new ArrayList<DagNode>();
	}

	public int numberOfVertices() {
		return inGraph.size();
	}

	public int numberOfEdges() {
		return edges;
	}

	private boolean validateVertex(DagNode v) {// the DagNode must be in the
		return inGraph.contains(v);
	}

	public void addEdge(DagNode v, DagNode w) {// in the format v points w
		if(validateVertex(v) == true && validateVertex(w) == true){
			w.adj.add(v);
			edges++;
		}
	}

	public ArrayList<DagNode> findAdjacent(DagNode v) {
		if (validateVertex(v) == true) {
			return v.adj;
		} else {
			return null;
		}
	}

	public void output() {
		for (int i = 0; i < inGraph.size(); i++) {
			System.out.print(inGraph.get(i).val + ": ");
			for (int j = 0; j < inGraph.get(i).adj.size(); j++) {
				System.out.print(inGraph.get(i).adj.get(j).val + ",");
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
