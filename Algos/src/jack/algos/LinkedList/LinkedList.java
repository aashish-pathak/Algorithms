package jack.algos.LinkedList;

public class LinkedList {
	public static void main(String[] args) {
		int in[] = {1,2,3,4,5,6};
		LinkedNode root = new LinkedNode();
		root = createLinkedList(in);
		traverseLinkedList(root);
	}
	
	public static LinkedNode createLinkedList(int[] in) {
		LinkedNode root = new LinkedNode();
		LinkedNode node = new LinkedNode();
		for(int i=0; i<in.length; i++) {
			LinkedNode temp = new LinkedNode(in[i]);
			if(i == 0) { 
				root = temp;
				node = root;
			} else {
				node.next = temp;
				node = node.next;
			}
		}
		return root;
	}
	
	public static void traverseLinkedList(LinkedNode root) {
		while(root != null) {
			System.out.print(root.value + " ");
			root = root.next;
		}
	}
}
