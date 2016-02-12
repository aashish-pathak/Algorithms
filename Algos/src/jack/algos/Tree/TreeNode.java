package jack.algos.Tree;

public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	public Boolean visited;
	
	public TreeNode() {
		this.value = 9999;
		this.left = null;
		this.right = null;
		this.visited = false;
	}
	
	public TreeNode(int v, TreeNode l, TreeNode r) {
		this.value = v;
		this.left = l;
		this.right = r;
		this.visited = false;
	}
}
