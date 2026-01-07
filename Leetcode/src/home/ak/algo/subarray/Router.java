/**
 * 
 */
package home.ak.algo.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kundu
 *
 */
public class Router {
	
	class PathNode {
		Map<String, PathNode> children;
		String value;
		
		public PathNode() {
			this.children = new HashMap<>();
		}
	}
	
	//Define the root of the trie
	PathNode root;
	
	public Router() {
		this.root = new PathNode();
		root.children.put("", new PathNode());
	}
	
	public void withRoute(String path, String result) {
		PathNode current = root;
		String[] folders = path.split("/");
		
		for(String folder: folders) {
			if(!current.children.containsKey(folder)) {
				current.children.put(folder, new PathNode());
			}
			current = current.children.get(folder);
		}
		current.value = result;
	}
	
	public String route(String path) {
		if (null == path || path.isEmpty()) {
			return "";
		}
		return handlePath(path.split("/"), 0, root);
	}

	private String handlePath(String[] folders, int idx, PathNode current) {
		if(idx == folders.length) {
			return current.value == null ? "": current.value;
		}
		
		if(null == current) {
			return "";
		}
		
		String folder = folders[idx];
		if(folder.equals("*")) {
			for(String nextFolder: current.children.keySet()) {
				return handlePath(folders, idx+1, current.children.get(nextFolder));
			}
		} else {
			return handlePath(folders, idx+1, current.children.get(folder));
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		Router router = new Router();
		router.withRoute("/foo", "foo");
		router.withRoute("/bar", "bar");
		System.out.println(router.route("/foo"));
	}

}
