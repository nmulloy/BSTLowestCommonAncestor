import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BFS {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean [] marked; //marked[v] = is there s->v path
	private int[] edgeTo; //edgeTo[v] = last edge on shortest s->v path
	private int[] distTo;// distTo[v] =length of shortest s->v path
	
	public BFS(DAG graph, int s){
		marked = new boolean[graph.numberOfVertices()];
		distTo = new int[graph.numberOfVertices()];
		edgeTo= new int[graph.numberOfVertices()];
		
		for(int i = 0; i < graph.numberOfVertices(); i++){
			distTo[i] = INFINITY;
		}
		
		validateVertex(s);
		search (graph, s);
	}
	
	private void search(DAG graph, int s){
		LinkedList<Integer> q = new LinkedList<Integer>();
		marked[s] = true;
		distTo[s] = 0;
		q.addLast(s);
		
		while(!q.isEmpty()){
			int v = q.removeFirst();
			for(int w : graph.findAdjacent(v)){
				if(!marked[w]){
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.addLast(w);
				}
			}
			
		}
		
		
	}
	

}
