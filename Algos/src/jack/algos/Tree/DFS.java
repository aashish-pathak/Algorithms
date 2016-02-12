package jack.algos.Tree;

import java.util.Stack;

public class DFS {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = BinarySearchTree.createBST();
		System.out.println("\nNon-recursive DFS: ");
		bst.preorder(root);
		System.out.println("\nNon-recursive DFS: ");
		nonRecursiveDFS(root);
	}
	
	/* Using stack to do DFS.  This implementation is doing pre-order traversal.*/
	public static void nonRecursiveDFS(TreeNode root) {
		Stack<TreeNode> dfsStack = new Stack<TreeNode>();
		TreeNode curr = new TreeNode();
		if(root == null)
			return;
		System.out.print(root.value + " ");
		root.visited = true;
		dfsStack.push(root);
		while(dfsStack.size() != 0) {
			curr = dfsStack.peek();
			if((curr.left != null) && (!curr.left.visited)) {
				System.out.print(curr.left.value + " ");
				dfsStack.push(curr.left);
			} else if((curr.right != null) && (!curr.right.visited)) {
				System.out.print(curr.right.value + " ");
				dfsStack.push(curr.right);
			} else {
				curr.visited = true;
				dfsStack.pop();
			}
		}
	}
}
