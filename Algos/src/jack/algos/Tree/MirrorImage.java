package jack.algos.Tree;

public class MirrorImage {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode();
		root = BinarySearchTree.createBST();
		System.out.println("Inorder traversal: ");
		BinarySearchTree.inorder(root);
		mirror(root);
		System.out.println("\nInorder traversal: ");
		BinarySearchTree.inorder(root);
	}
	
	public static TreeNode mirror(TreeNode root) {
		TreeNode tmp = new TreeNode();
		if(root == null) 
			return null;
		mirror(root.left);
		mirror(root.right);
		
		tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		return root;
	}
}
