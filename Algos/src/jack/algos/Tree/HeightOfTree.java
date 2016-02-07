package jack.algos.Tree;

public class HeightOfTree {
	public static int main(TreeNode root) {
		if(root == null)
			return 0;
		else{
			int lHeight = main(root.left);
			int rHeight = main(root.right);
			
			if (lHeight > rHeight)
                return(lHeight+1);
            else return(rHeight+1); 
		}
	}
}
