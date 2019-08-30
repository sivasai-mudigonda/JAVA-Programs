package practice;

public class SecondLargeEleBTree {

	public static void main(String[] args) {
		BST tree = new BST(); 
        
        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
         
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
       // tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
  
        tree.secondLargest(tree.root);
	}
}

class Count{
	int count;
}

class Node { 
	  
    int data; 
    Node left, right; 
  
    Node(int d) 
    { 
        data = d; 
        left = right = null; 
    } 
} 

class BST { 
	  
    // Root of BST 
    Node root; 
  
    // Constructor 
    BST() 
    { 
        root = null; 
    } 
  
    // function to insert new nodes 
    public void insert(int data) 
    { 
        this.root = this.insertRec(this.root, data); 
    } 
      
    /* A utility function to insert a new node with given  
    key in BST */
    Node insertRec(Node node, int data) 
    { 
        /* If the tree is empty, return a new node */
        if (node == null) { 
            this.root = new Node(data); 
            return this.root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (data < node.data) { 
            node.left = this.insertRec(node.left, data); 
        } else { 
            node.right = this.insertRec(node.right, data); 
        } 
        return node; 
    }
    
	public void secondLargest(Node root) {
		Count cnt= new Count();
		calSecondLargest(root,cnt);
	}
	
	public void calSecondLargest(Node node,Count cnt) {
		if(node==null || cnt.count>=2 ){
			return;
		}
		
		calSecondLargest(node.right,cnt);
		cnt.count++;
		if(cnt.count==2) {
			System.out.println("Second largest element is "+node.data);
			return;
		}
		
		calSecondLargest(node.left,cnt);
	}
}
