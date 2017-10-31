import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	private static void setColourBlue(DAG graph, DagNode s) {
		LinkedList<DagNode> q = new LinkedList<DagNode>();
		q.addLast(s);

		while (!q.isEmpty()) {
			DagNode v = q.removeFirst();
			for (int i = 0; i < v.adj.size(); i++) {
				v.adj.get(i).colour = "blue";
				q.addLast(v.adj.get(i));
			}

		}
	}

	private static void setColourRed(DAG graph, DagNode s) {
		LinkedList<DagNode> q = new LinkedList<DagNode>();
		q.addLast(s);

		while (!q.isEmpty()) {
			DagNode v = q.removeFirst();
			for (int i = 0; i < v.adj.size(); i++) {
				if (v.adj.get(i).colour == "blue") {
					v.adj.get(i).colour = "red";
					for(int j = 0; j < v.adj.get(i).adj.size(); j++){
						v.adj.get(i).adj.get(j).count++;
					}
				}
				q.addLast(v.adj.get(i));
			}
		}

	}
	
	private static void LCAInDAG(DAG graph, DagNode v, DagNode w){
		setColourBlue(graph,v);
		setColourRed(graph,w);
		
		System.out.print("The lowest common ancestor(s): ");
		for(int i = 0; i < graph.inGraph.size(); i++){
			if(graph.inGraph.get(i).colour == "red" && graph.inGraph.get(i).count == 0){
				System.out.print(graph.inGraph.get(i).val + ", ");
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		DAG graph = new DAG();
		
		DagNode A = new DagNode("A");
		DagNode B  = new DagNode("B");
		DagNode C  = new DagNode("C");
		DagNode D  = new DagNode("D");
		DagNode E  = new DagNode("E");
		DagNode F  = new DagNode("F");
		DagNode G  = new DagNode("G");
		DagNode H  = new DagNode("H");
		DagNode I  = new DagNode("I");
		
		graph.inGraph.add(A);
		graph.inGraph.add(B);
		graph.inGraph.add(C);
		graph.inGraph.add(D);
		graph.inGraph.add(E);
		graph.inGraph.add(F);
		graph.inGraph.add(G);
		graph.inGraph.add(H);
		graph.inGraph.add(I);
		
		graph.addEdge(C, A);
		graph.addEdge(E, C);
		graph.addEdge(D, B);
		graph.addEdge(E, D);
		graph.addEdge(F, C);
		graph.addEdge(F, D);
		graph.addEdge(G, F);
		graph.addEdge(H, F);
		graph.addEdge(I, H);
		
		//graph.output();
		
		/*for(int i = 0; i < graph.inGraph.size(); i++){
			System.out.println(graph.inGraph.get(i).val + ": " + graph.inGraph.get(i).colour + " count:" + graph.inGraph.get(i).count);
		}*/
		
		LCAInDAG(graph,A,B);
		
	}
	
}
