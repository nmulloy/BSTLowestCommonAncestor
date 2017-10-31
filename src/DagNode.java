import java.util.ArrayList;

public class DagNode{
		Object val;
		String colour = "white";
		ArrayList<DagNode> adj;
		int count;
		
		public DagNode (Object val){
			this.val = val;
			this.adj = new ArrayList<DagNode>();
			this.count = 0;
		}
	
}