import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	private static void setColourBlue(DAG graph, NodeInfo s) {
		LinkedList<NodeInfo> q = new LinkedList<NodeInfo>();
		q.addLast(s);

		while (!q.isEmpty()) {
			NodeInfo v = q.removeFirst();
			for (int i = 0; i < v.adj.size(); i++) {
				v.adj.get(i).colour = "blue";
				q.addLast(v.adj.get(i));
			}

		}
	}

	private static void setColourRed(DAG graph, NodeInfo s) {
		LinkedList<NodeInfo> q = new LinkedList<NodeInfo>();
		q.addLast(s);

		while (!q.isEmpty()) {
			NodeInfo v = q.removeFirst();
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
	
	private static void LCAInDag(NodeInfo v, NodeInfo w, DAG graph){
		setColourBlue(graph,v);
		setColourRed(graph,w);
		
		System.out.print("The lowest common ancestor(s): ");
		for(int i = 0; i < graph.inGraph.size(); i++){
			
		}
	}
	
	
	
	public static void main(String[] args) {
		DAG graph = new DAG();
		
		NodeInfo A = new NodeInfo("A");
		NodeInfo B  = new NodeInfo("B");
		NodeInfo C  = new NodeInfo("C");
		NodeInfo D  = new NodeInfo("D");
		NodeInfo E  = new NodeInfo("E");
		NodeInfo F  = new NodeInfo("F");
		NodeInfo G  = new NodeInfo("G");
		NodeInfo H  = new NodeInfo("H");
		NodeInfo I  = new NodeInfo("I");
		
		graph.inGraph.add(A);
		graph.inGraph.add(B);
		graph.inGraph.add(C);
		graph.inGraph.add(D);
		graph.inGraph.add(E);
		graph.inGraph.add(F);
		graph.inGraph.add(G);
		graph.inGraph.add(H);
		graph.inGraph.add(I);
		
		graph.addEdge(E, C);
		graph.addEdge(C, A);
		graph.addEdge(E, D);
		graph.addEdge(D, B);
		graph.addEdge(F, E);
		graph.addEdge(G, E);
		graph.addEdge(H, G);
		graph.addEdge(I, C);
		graph.addEdge(I, D);
		
		graph.output();
		
		
		
		for(int i = 0; i < graph.inGraph.size(); i++){
			System.out.println(graph.inGraph.get(i).val + ": " + graph.inGraph.get(i).colour + " count:" + graph.inGraph.get(i).count);
		}
		
	}
	
}
