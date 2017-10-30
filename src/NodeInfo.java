import java.util.ArrayList;

public class NodeInfo {
		Object val;
		String colour = "white";
		int index;
		ArrayList<NodeInfo> adj;
		int count;
		
		public NodeInfo(Object val, int index){
			this.val = val;
			this.index = index;
			this.adj = new ArrayList<NodeInfo>();
			this.count = 0;
		}
	
}