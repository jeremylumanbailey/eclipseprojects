// @author Jeremy Bailey

package cmsc401;

import java.util.*;

public class MyBinaryTree {
	
	/*Create BTNode class. Built a few constructors a default one, one that just
	 * takes in a key, and one that takes everything. Went ahead and set up the setters and 
	 * getters, even if I did not end up using most of them. 
	 * I made full use of BTNode left and BTNode right but did not have to use the BTNode parent to 
	 * properly function.
	 * 
	 */
	public class BTNode {
		
		BTNode()
		{

		}
		
		BTNode(int k)
		{
			this.key = k;
		}
		
		BTNode(int k, BTNode p, BTNode l, BTNode r)
		{
			this.key = k;
			this.parent = p;
			this.left = l;
			this.right = r;
		}

		int key;
		BTNode parent;
		BTNode left;
		BTNode right;
		
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public BTNode getParent() {
			return parent;
		}
		public void setParent(BTNode parent) {
			this.parent = parent;
		}
		public BTNode getLeft() {
			return left;
		}
		public void setLeft(BTNode left) {
			this.left = left;
		}
		public BTNode getRight() {
			return right;
		}
		public void setRight(BTNode right) {
			this.right = right;
		}
		
	}
	
	BTNode root;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		 if (input.hasNextLine()) {
      String userInput = input.nextLine();
      String[] array = userInput.split("\\s+");
      int[] integerArray = new int[array.length];
      for (int i = 0; i < array.length; i++) {
          integerArray[i] = Integer.parseInt(array[i]);
          
      }
      input.close();
      makeBinaryTree(integerArray);
		 }	 
	}
	
	public static void makeBinaryTree(int[] array) {	
		
	    MyBinaryTree BT = new MyBinaryTree();
	    
	    for (int i = 0; i < array.length; i++) {
	          BT.add(array[i]);
	      }
	    
	    //if input: 5 10 7 101 42 1 21 9998 -65
	    String inOrder = BT.inOrder();
	    
	    //then output: -65 1 5 7 10 21 42 101 9998
	    System.out.println(inOrder);
	    
	    
	}
	
	
	BTNode addNode(BTNode currentNode, int newNum) {
		if(currentNode == null) {
			return new BTNode(newNum);
		}
		
		if(newNum < currentNode.key) {
			currentNode.left = addNode(currentNode.left, newNum);
		}
		else if (newNum > currentNode.key) {
			currentNode.right = addNode(currentNode.right, newNum);
		}
		else {
			return currentNode;
		}
		
		return currentNode;
	}
	
	// This method will add a new integer number into the binary search tree
	void add(int newNum) {
	
		root = addNode(root, newNum);
		
	}
	
	private int findSmallestKey(BTNode root) {
	 
	    		if(root.left == null) {
	    			return root.key; 
	    		}	
	    		else { 
	    			return findSmallestKey(root.left);
	    		}
	    		
	}
	
	BTNode deleteNode(BTNode current, int delNum) {
	    if (current == null) {
	        return null;
	    }
	 
	    if (delNum == current.key) {
	    	
	    	if (current.left == null && current.right == null) {
	    	    return null;
	    	}
	    	
	    	if (current.right == null) {
	    	    return current.left;
	    	}
	    	 
	    	if (current.left == null) {
	    	    return current.right;
	    	}
	    	
	    	
	    	int smallestValue = findSmallestKey(current.right);
	    	current.key = smallestValue;
	    	current.right = deleteNode(current.right, smallestValue);
	    	return current;
	    	
	    	
	    } 
	    if (delNum < current.key) {
	        current.left = deleteNode(current.left, delNum);
	        return current;
	    }
	    current.right = deleteNode(current.right, delNum);
	    return current;
	}
	
		// Delete the number delNum if it exists. Return true if
		//	succeeds and or return false if the number does not exist.
	 boolean delete(int delNum) {
		 
		 if(hasNode(root, delNum)) {
		    root = deleteNode(root, delNum);
		   return true;
		 }
		 else{
		   return false;
		 }
		    
	}
	
	 // Check whether the tree contains the number num or not.	
	 boolean contains(int num) {
		return hasNode(root, num);
	 }
	
	 private boolean hasNode(BTNode currentNode, int num) {
		if(currentNode == null) {
			return false;
		}
		if(num == currentNode.key) {
			return true;
		}
		
		if(num < currentNode.key)  {
			return hasNode(currentNode.left, num);
					
		}
		else {
			return hasNode(currentNode.right, num);
		}
				
	}
	 
	 public void printInOrder(StringBuilder stringbuilder, BTNode node) {
		    if (node != null) {
		        printInOrder(stringbuilder, node.left);
		        stringbuilder.append(" " + Integer.toString(node.key));
		        printInOrder(stringbuilder, node.right);
		    }
		}

	 public void printPreOrder(StringBuilder stringbuilder, BTNode node) {
		    if (node != null) {
		    	stringbuilder.append(" " + Integer.toString(node.key));
		        printPreOrder(stringbuilder, node.left);
		        printPreOrder(stringbuilder, node.right);
		    }
		}
	 
	 public void printPostOrder(StringBuilder stringbuilder, BTNode node) {
		    if (node != null) {
		        printPostOrder(stringbuilder, node.left);
		        printPostOrder(stringbuilder, node.right);
		        stringbuilder.append(" " + Integer.toString(node.key));
		      
		    }
		}
	 
	// Return the preorder traversal result (numbers are separated by spaces)
		 
	 String inOrder() {
		 StringBuilder stringBuilder = new StringBuilder();
		 
		printInOrder(stringBuilder,root);
		 
		 return stringBuilder.toString();
	 }
	 
	 // Return the preorder traversal result (numbers are separated by spaces)
	 String preOrder() {
		 StringBuilder stringBuilder2 = new StringBuilder();
		 
		 printPreOrder(stringBuilder2, root);
		 
		 return stringBuilder2.toString();
	 }
	 
	// Return the postorder traversal result (numbers are separated by spaces)
	 String postOrder() {
		 StringBuilder stringBuilder3 = new StringBuilder();
		 
		 printPostOrder(stringBuilder3, root);
		 
		 return stringBuilder3.toString();
	 }
	 
	 
}
