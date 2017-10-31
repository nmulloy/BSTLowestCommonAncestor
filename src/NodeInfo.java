import java.util.ArrayList;

public class NodeInfo {
		Object val;
		String colour = "white";
		ArrayList<NodeInfo> adj;
		int count;
		
		public NodeInfo(Object val){
			this.val = val;
			this.adj = new ArrayList<NodeInfo>();
			this.count = 0;
		}
	
}