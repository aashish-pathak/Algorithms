package jack.algos.Tree;
public class TreeFromTraversals {
	static int in[] = {1,3,4,6,7,8,10,13,14};
	static int pre[] = {8,3,1,6,4,7,10,14,13};
	static int index;
	static TreeNode root = new TreeNode();
	
	public static void main(String[] args) {
		root = constructTree(0, in.length-1);
		BinarySearchTree bst = new BinarySearchTree();
		bst.inorder(root);
	}
	
	public static TreeNode constructTree(int start, int end) {
		TreeNode node = new TreeNode();
		int tmpRoot;
		tmpRoot = getRoot(start, end);
		if(tmpRoot == 9999)
			return null;
		node.value = tmpRoot;
		node.left = constructTree(start, indexOf(in, tmpRoot)-1);
		node.right = constructTree(indexOf(in, tmpRoot)+1, end);
		return node;
	}
	
	public static int getRoot(int startI, int endI) {
		if ((startI>=in.length-1) || (endI<0) || (startI > endI))
			return 9999;
		int retVal = pre[index];
		index++;
		return retVal;
	}
	
	public static int indexOf(int[] arr, int num) {
		for (int i=0; i<arr.length; i++) {
			if(arr[i] == num)
				return i;
		}
		return -1;
	}
}
