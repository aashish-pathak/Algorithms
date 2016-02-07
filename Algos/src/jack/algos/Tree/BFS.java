package jack.algos.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = BinarySearchTree.createBST();
		System.out.println("Recursive BFS: ");
		recursiveBFS(root);
		System.out.println("\nNon-recursive BFS: ");
		nonRecursiveBFS(root);
	}
	
	public static void nonRecursiveBFS(TreeNode root) {
		Queue<TreeNode> q =  new LinkedList<TreeNode>();
		if(root == null)
			return;
		q.add(root);
		while(q.size() != 0) {
			TreeNode currElement = q.remove();
			System.out.print(currElement.value + " ");
			if(currElement.left != null)
				q.add(currElement.left);
			if(currElement.right != null)
				q.add(currElement.right);
		} 
	}

	public static void recursiveBFS(TreeNode root) {
		HeightOfTree h = new HeightOfTree();
		int height = HeightOfTree.main(root);
		System.out.println("height is: " + height);
		for(int i=1; i<=height; i++) 
			printLevel(root, i);
	}
	
	public static void printLevel(TreeNode root, int level) {
		if(root == null) 
			return;
		if(level == 1)
			System.out.print(root.value + " ");
		else if(level > 1) {
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}
}
