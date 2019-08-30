/**
 * 
 */
package practice;

/**
 * @author SIVA SAI
 *
 */

// Time Complexity: O(n)

/*Diameter of Binary Tree:
https://www.youtube.com/watch?v=ey7DYc9OANo

Height of Binary Tree:
https://www.youtube.com/watch?v=_O-mK2g_jhI
*/

public class BinaryTreeDiameter {

	/**
	 * @param args
	 */
	
	Node root=null;
	public static void main(String[] args) {
		BinaryTreeDiameter tree= new BinaryTreeDiameter();		
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
		
		Height height = new Height();
		System.out.println("Diameter = "+calDiameterBT(tree.root,height));
	}
	
	
	private static int calDiameterBT(Node root, Height height) {
		if(root==null) {
			height.h=0;
			return 0;
		}
		
		Height leftHeight= new Height();
		Height rightHeight= new Height();
		
		int leftDiameter=calDiameterBT(root.left,leftHeight);
		int rightDiameter=calDiameterBT(root.right,rightHeight);
		
		height.h=Math.max(leftHeight.h, rightHeight.h)+1;
		
		return Math.max(1+leftHeight.h+rightHeight.h,Math.max(leftDiameter,rightDiameter));
	}
	
	private static class Node{
		int key;
		Node left,right;
		
		Node(int key){
			this.key=key;
			left=right=null;
		}
	}
	
	private static class Height{
		int h;
	}
}
