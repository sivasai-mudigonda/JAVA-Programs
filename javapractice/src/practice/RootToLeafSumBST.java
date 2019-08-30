package practice;

public class RootToLeafSumBST {

	Node root;
	public static void main(String[] args) {
		RootToLeafSumBST tree = new RootToLeafSumBST(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(2); 
		System.out.println(calSumRootToLeaf(tree.root,10));
	}
	
	// Refer https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
	// Time complexity is O(N)
	private static Boolean calSumRootToLeaf(Node node, int target) {
		int sub_sum=target-node.key;
		boolean ans=false;
		if(sub_sum==0) {
			ans=true;
			return ans;
		} else if(node.left!=null){
			calSumRootToLeaf(node.left,sub_sum);
		} else if(node.right!=null){
			calSumRootToLeaf(node.right,sub_sum);
		}
		return ans;
	}
	
	private static class Node{
		int key;
		Node left,right;
		
		Node(int key){
			this.key=key;
		}
	}

}
