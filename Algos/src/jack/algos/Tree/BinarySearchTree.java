package jack.algos.Tree;

public class BinarySearchTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		HeightOfTree h = new HeightOfTree();
		root = createBST();
		//System.out.println(root.value + " " + root.left.value + " " + root.right.value);
		System.out.println("Height of the tree: " + HeightOfTree.main(root));
		
		System.out.println("Recursive inorder traversal: ");
		inorder(root);
		System.out.println("\nRecursive preorder traversal: ");
		preorder(root);
		System.out.println("\nRecursive postorder traversal: ");
		postorder(root);
	}
	
	public static TreeNode createBST() {
		int [] in = {8,3,10,1,6,4,7,14,13};
		//int [] in = {50,25,75,12,37,62,87,6,18,31,43,57,69,81,93,40,60,90,95};
		TreeNode root = new TreeNode(in[0], null, null);
		for (int i=1; i<in.length; i++) {
			TreeNode currNode = new TreeNode(in[i], null, null);
			insertNode(root, currNode);
		}
		return root;
	}
	
	public static void insertNode(TreeNode root, TreeNode insert) {
		TreeNode node = root;
		if (node.value > insert.value) {
			if (node.left == null) {
				node.left = insert;
			} else {
				insertNode(node.left, insert);
			}
		} else {
			if (node.right == null) {
				node.right = insert;
			} else {
				insertNode(node.right, insert);
			}
		}
	}
	
	public static void inorder(TreeNode root) {
		if(root.left != null)
			inorder(root.left);
		System.out.print(root.value + " ");
		if(root.right != null)
			inorder(root.right);
	}
	
	public static void preorder(TreeNode root) {
		System.out.print(root.value + " ");
		if(root.left != null)
			preorder(root.left);
		if(root.right != null)
			preorder(root.right);
	}
	
	public static void postorder(TreeNode root) {
		if(root.left != null)
			postorder(root.left);
		if(root.right != null)
			postorder(root.right);
		System.out.print(root.value + " ");
	}
}
