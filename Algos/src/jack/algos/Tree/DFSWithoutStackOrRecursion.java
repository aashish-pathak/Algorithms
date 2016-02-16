package jack.algos.Tree;

public class DFSWithoutStackOrRecursion {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = new TreeNode();
		root = bst.createBST();
		inorderTraverse(root);
	}
	
	public static void inorderTraverse(TreeNode root) {
		Boolean leftDone = false;
		System.out.println("Inorder traversal is: ");
		
		while(root != null) {
			// If left child is not traversed, find the leftmost child
			if(!leftDone) {
				while(root.left != null)
					root = root.left;
			}
			
			//print root's value 
			System.out.print(root.value + " ");
			
			//mark left as done
			leftDone = true;
			
			//if right child exist, go to right subtree
			if(root.right != null) {
				leftDone = false;
				root = root.right;
			}
			
			// If right child doesn't exist, move to parent
			else if(root.parent != null) {
				// If this node is right child of its parent, visit parent's parent first
				while((root.parent != null) && (root == root.parent.right))
					root = root.parent;
				if(root.parent == null) 
					break;
	            root = root.parent;
			}
			else
				break;
		}
	}
}
