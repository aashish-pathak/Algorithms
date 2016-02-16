package jack.algos.Tree;

public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	public Boolean visited;
	
	/* following parent node is not mandatory
	 * this has been added for the problem of traversing the tree without using recursion or stack/queue
	 */
	public TreeNode parent;
	
	public TreeNode() {
		this.value = 9999;
		this.left = null;
		this.right = null;
		this.visited = false;
		
		//not mandatory
		this.parent = null;
	}
	
	public TreeNode(int v, TreeNode l, TreeNode r, TreeNode p) {
		this.value = v;
		this.left = l;
		this.right = r;
		this.visited = false;
		
		//not mandatory
		this.parent = p;
	}
}
