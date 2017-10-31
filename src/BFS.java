import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	private void setColourBlue(DAG graph, DagNode s) {
		LinkedList<DagNode> q = new LinkedList<DagNode>();// new linked list, acts as queue
		q.addLast(s);

		while (!q.isEmpty()) {
			DagNode v = q.removeFirst();//pops the first
			for (int i = 0; i < v.parents.size(); i++) {//cycles through the node's parents
				v.parents.get(i).colour = "blue";//sets the parents' colour blue
				q.addLast(v.parents.get(i));// adds the parents to the list to cycle through their parents
			}

		}
	}

	private void setColourRed(DAG graph, DagNode s) {
		LinkedList<DagNode> q = new LinkedList<DagNode>();
		q.addLast(s);

		while (!q.isEmpty()) {
			DagNode v = q.removeFirst();
			for (int i = 0; i < v.parents.size(); i++) {//cycles through all of its parents
				if (v.parents.get(i).colour == "blue") {// if the parent is blue aka been visited by the other node
					v.parents.get(i).colour = "red";//changes it to red
					for (int j = 0; j < v.parents.get(i).parents.size(); j++) {//cycles through the parent's node paents
						v.parents.get(i).parents.get(j).countOfRedChildNodes++;//changes its count of how many red child nodes it has
					}
				}
				q.addLast(v.parents.get(i));//adds the parents to the queue
			}
		}

	}

	private void LCAInDAG(DAG graph, DagNode v, DagNode w) {
		setColourBlue(graph, v);//sets all the parents of v blue
		setColourRed(graph, w);//sets all the parents w that are blue red and adds to the red child count

		System.out.print("The lowest common ancestor(s): ");
		for (int i = 0; i < graph.inGraph.size(); i++) {//searches through the graph
			if (graph.inGraph.get(i).colour == "red" && graph.inGraph.get(i).countOfRedChildNodes == 0) {//if the node is red and its count is zero it is the LCA
				System.out.print(graph.inGraph.get(i).val + ", ");
			}
		}
	}
}
