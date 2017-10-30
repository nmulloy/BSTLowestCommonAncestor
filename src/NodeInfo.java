import java.util.ArrayList;

public class NodeInfo {
		Object val;
		private String colour = "white";
		int index;
		ArrayList<NodeInfo> adj;
		
		public NodeInfo(Object val, int index){
			this.val = val;
			this.index = index;
			this.adj = new ArrayList<NodeInfo>();
		}
	
}