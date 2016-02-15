package jack.algos.LinkedList;

public class ReverseLinkedList {
	public static void main(String[] args) {
		LinkedNode root = new LinkedNode();
		LinkedList ll = new LinkedList();
		int [] in = {1,2,3,4,5};
		root = ll.createLinkedList(in);
		System.out.println("Before reverting ");
		ll.traverseLinkedList(root);
		root = reverseLL(root);
		System.out.println("After reverting ");
		ll.traverseLinkedList(root);
	}
	
	public static LinkedNode reverseLL(LinkedNode root) {
		LinkedNode previousNode=null;  
		LinkedNode a,b;
		a = root;
		  while(a!=null)  
		  {  
		   b=a.next;  
		  // reversing the link  
		   a.next=previousNode;  
		  // moving currentNode and previousNode by 1 node  
		   previousNode=a;  
		   a=b;  
		  }  
		  return previousNode; 
	}
}
