import java.util.ArrayList;
import java.util.LinkedList;


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

	public void addEdge(DagNode v, DagNode w) throws IllegalArgumentException {// in the format v points to w
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
	
	private void setColourBlue(DagNode s) {
		LinkedList<DagNode> q = new LinkedList<DagNode>();// new linked list,
															// acts as queue
		q.addLast(s);

		while (!q.isEmpty()) {
			DagNode v = q.removeFirst();// pops the first
			for (int i = 0; i < v.parents.size(); i++) {// cycles through the
														// node's parents
				v.parents.get(i).colour = "blue";// sets the parents' colour
													// blue
				q.addLast(v.parents.get(i));// adds the parents to the list to
											// cycle through their parents
			}

		}
	}

	private void setColourRed(DagNode s) {
		LinkedList<DagNode> q = new LinkedList<DagNode>();
		q.addLast(s);

		while (!q.isEmpty()) {
			DagNode v = q.removeFirst();
			for (int i = 0; i < v.parents.size(); i++) {// cycles through all of
														// its parents
				if (v.parents.get(i).colour == "blue") {// if the parent is blue
														// aka been visited by
														// the other node
					v.parents.get(i).colour = "red";// changes it to red
					for (int j = 0; j < v.parents.get(i).parents.size(); j++) {//cycles through the parent node's parent
																			  //and adds 1 to to its count
						v.parents.get(i).parents.get(j).countOfRedChildNodes++;
					}
				}
				q.addLast(v.parents.get(i));// adds the parents to the queue
			}
		}

	}

	public String LCAInDAG(DagNode v, DagNode w) {
			if (isEmpty() == false && validateVertex(v) == true && validateVertex(w) == true) {
				String result = "";
				setColourBlue(v);// sets all the parents of v blue
				setColourRed(w);// sets all the parents w that are blue
										// red
										// and adds to the red child count
				result += "The lowest common ancestor(s):";
				for (int i = 0; i < inGraph.size(); i++) {// searches
																// through
																// the graph
					if (inGraph.get(i).colour == "red" 
						&& inGraph.get(i).countOfRedChildNodes == 0){// if the colour is red and count = 0 it is the LCA
						result += inGraph.get(i).val + ",";
					}
				}
			return result;
			}
			else{
				return null;
			}
		} 
	
	public void DFS(DagNode v){
		for(int i = 0; i < v.parents.size(); i++){
			if(!v.parents.get(i).visitedInDfs){
			v.parents.get(i).visitedInDfs = true;
			DFS(v.parents.get(i));
			}
		}
	}
	
	public boolean isDag(){
		if(!isEmpty()){
			DFS(inGraph.get(0));
			for(int i = 0; i < inGraph.size(); i++){
				if(inGraph.get(i).visitedInDfs == false){
					return true;
				}
			}
		}
		return false;
	}
		
}
