import java.util.ArrayList;

public class DagNode {
	Object val; //value of node
	String colour = "white";// colour of node *used to find LCA
	ArrayList<DagNode> parents;// ArrayList of all the node's parents
	int countOfRedChildNodes = 0;// count of how many of its child nodes are red

	public DagNode(Object val, DAG graph) {
		this.val = val;
		this.parents = new ArrayList<DagNode>();
		graph.inGraph.add(this);
	}

}