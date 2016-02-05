package jack.algos.Tree;

public class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode() {
		this.value = 9999;
		this.left = null;
		this.right = null;		
	}
	
	public TreeNode(int v, TreeNode l, TreeNode r) {
		this.value = v;
		this.left = l;
		this.right = r;
	}
}
