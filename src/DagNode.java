import java.util.ArrayList;

public class DagNode{
		Object val;
		String colour = "white";
		ArrayList<DagNode> parents;
		int count;
		
		public DagNode (Object val){
			this.val = val;
			this.parents = new ArrayList<DagNode>();
			this.count = 0;
		}
	
}