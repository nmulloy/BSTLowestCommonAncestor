import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class DAGTest {

	@Test
	public void testNumberOfVertices() {
		DAG graph = new DAG();
		assertTrue("Checks that nothing is in the graph", graph.isEmpty());
		
		DagNode A = new DagNode("A", graph);
		DagNode B = new DagNode("B", graph);
		
		assertFalse("Checks that nothing is in the graph", graph.isEmpty());
		assertEquals("Putting in the same value again", 2, graph.numberOfVertices());
	}
	
	@Test
	public void testValidateVertex() {
		DAG graph = new DAG();
		DAG newGraph = new DAG();
		
		DagNode A = new DagNode("A", graph);
		DagNode X = new DagNode("X", newGraph);
		
		assertFalse("Checks for an invalid vertex", graph.validateVertex(X));
		assertTrue("Checks for an valid vertex", graph.validateVertex(A));
	}

	@Test
	public void testNumberOfEdges(){
		DAG graph = new DAG();
		
		assertEquals("number of edges should be zero", 0, graph.numberOfEdges());
		
		DagNode A = new DagNode("A", graph);
		DagNode B = new DagNode("B", graph);
		DagNode C = new DagNode("C", graph);
		
		graph.addEdge(B,A);
		graph.addEdge(B,C);
		
		assertEquals("number of edges should be 2", 2, graph.numberOfEdges());
	}
	/*
	public int numberOfEdges() {
		return edges;// returns the number of edges in the DAG
	}

	private boolean validateVertex(DagNode v) {// the DagNode must be in the the
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

	public ArrayList<DagNode> findParents(DagNode v) {// returns all parent
														// nodes to the vertex
		if (validateVertex(v) == true) {
			return v.parents;
		} else {
			return null;
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
}*/


}
