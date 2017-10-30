import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
	
	public boolean hasPathTo(int v){
		validateVertex(v);
		return marked[v];
	}
	
	public int distTo(int v) {
		validateVertex(v);
		return distTo[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		validateVertex(v);
		
		if(!hasPathTo(v)){
			return null;
		}
		else{
			Stack<Integer> path = new Stack<Integer>();
			int x;
			for(x = v; distTo[x] != 0; x = edgeTo[x]){
				path.push(x);
			}
			path.push(x);
			return path;
		}
	}
	
	private void validateVertex(int v) {
	        int V = marked.length;
	        if (v < 0 || v >= V)
	            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
	public static void main(String[] args) {
		 DAG graph = new DAG(13);
		  graph.addEdge(4, 2);
		  graph.addEdge(2, 3);
		  graph.addEdge(3, 2);
		  graph.addEdge(6, 0);
		  graph.addEdge(0, 1);
		  graph.addEdge(2, 0);
		  graph.addEdge(11, 12);
		  graph.addEdge(12, 9);
		  graph.addEdge(9, 10);
		  graph.addEdge(9, 11);
		  graph.addEdge(10, 12);
		  graph.addEdge(11, 4);
		  graph.addEdge(4, 3);
		  graph.addEdge(3, 5);
		  graph.addEdge(6, 8);
		  graph.addEdge(8, 6);
		  graph.addEdge(5, 4);
		  graph.addEdge(0, 5);
		  graph.addEdge(6, 4);
		  graph.addEdge(6, 9);
		  graph.addEdge(7, 6);
		  
		  BFS test = new BFS(graph,7);
		  
		  for(int i = 0; i < graph.numberOfVertices(); i++){
			  if(test.hasPathTo(i)){
				  System.out.println(7 + " has a path to " + i + " with distance: " + test.distTo(i));
				  for(int x : test.pathTo(i)){
					  if(x == 7){
						  System.out.print(x);
					  }
					  else{
						  System.out.print(x + " -> ");
					  }
				  }
				  System.out.println();
			  }
			  else{
				  System.out.println("7 and " + i +" are not connected");
			  }
		  }
		  
		  test = new BFS(graph,4);
		  
		  for(int i = 0; i < graph.numberOfVertices(); i++){
			  if(test.hasPathTo(i)){
				  System.out.println(4 + " has a path to " + i + " with distance: " + test.distTo(i));
				  for(int x : test.pathTo(i)){
					  if(x == 4){
						  System.out.print(x);
					  }
					  else{
						  System.out.print(x + " -> ");
					  }
				  }
				  System.out.println();
			  }
			  else{
				  System.out.println("4 and " + i +" are not connected");
			  }
		  }
	}
	
}
