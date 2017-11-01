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
	public void testNumberOfEdges() {
		DAG graph = new DAG();
		DAG newGraph = new DAG();

		DagNode A = new DagNode("A", graph);
		DagNode B = new DagNode("B", graph);
		DagNode C = new DagNode("C", graph);

		DagNode X = new DagNode("X", newGraph);

		graph.addEdge(A, X);

		assertEquals("number of edges should be zero", 0, graph.numberOfEdges());

		graph.addEdge(B, A);
		graph.addEdge(B, C);

		assertEquals("number of edges should be 2", 2, graph.numberOfEdges());
	}
	 @Test
	 public void testOutput(){
		 
		
		 DAG graph = new DAG();
	       
		 assertNull("Checking output of non-empty graph", graph.output());
		 
		 String result = "A:C,\nB:D,\nC:E,\nD:E,\nE:\n";
		 
	      DagNode A = new DagNode("A",graph);
	      DagNode B = new DagNode("B",graph);
	      DagNode C = new DagNode("C",graph);
	      DagNode D = new DagNode("D",graph);
	      DagNode E = new DagNode("E",graph);
	       
	      graph.addEdge(C, A); 
	      graph.addEdge(E, C);
	      graph.addEdge(D, B);
	      graph.addEdge(E, D);
	      
	      assertEquals("Checking output of non-empty graph", result, graph.output());
	 }

}
