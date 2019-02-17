// @author Jeremy Bailey

/*   
	You are asked to implement a binary search tree class named MyBinaryTree that satisfies the
	following requirements:
		1. It will use the following class as the binary tree node.
		class BTNode {
		int key;
		BTNode parent;
		BTNode left;
		BTNode right;
		}
		
		2. It should contain but not limited to the following methods:
		void add(int newNum) // This method will add a new integer number into the binary
		search tree.
		boolean delete(int delNum) // Delete the number delNum if it exists. Return true if
		succeeds and or return false if the number does not exist.
		boolean contains (int num) // Check whether the tree contains the number num or
		not.
		String inOrder() // Return the inorder traversal result (numbers are separated by spaces)
		String preOrder() // Return the preorder traversal result (numbers are separated by
		spaces)
		String postOrder() // Return the postorder traversal result (numbers are separated by
		spaces)
		
		3. It should have a main method that reads a sequence of numbers from the terminal and
		print the sorted results. For example:
		>java MyBinaryTree 5 10 7 101 42 1 21 9998 -65
		-65 1 5 7 10 21 42 101 9998
 */

package cmsc401;

import java.util.Arrays;
import java.util.Scanner;
import cmsc401.BTNode;

public class MyBinaryTree {
	
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

	    String inOrder = BT.inOrder();
	    System.out.println("inorder: " + inOrder);
	    String preorder = BT.preOrder();
	    System.out.println("preorder: " + preorder);
	    String postOrder = BT.postOrder();
	    System.out.println("postorder: " + postOrder);
	    
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
	
	//Delete the number delNum if it exists. Return true if
		//	succeeds and or return false if the number does not exist.
	 boolean delete(int delNum) {
		 
		 if(containsNode(root, delNum)) {
		    root = deleteNode(root, delNum);
		   return true;
		 }
		 else{
		   return false;
		 }
		    
	}
	
	 // Check whether the tree contains the number num or not.	
	 boolean contains(int num) {
		return containsNode(root, num);
	 }
	
	 private boolean containsNode(BTNode currentNode, int num) {
		if(currentNode == null) {
			return false;
		}
		if(num == currentNode.key) {
			return true;
		}
		
		if(num < currentNode.key)  {
			return containsNode(currentNode.left, num);
					
		}
		else {
			return containsNode(currentNode.right, num);
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


//public static MyBinaryTree createBinaryTree() {
//MyBinaryTree BT = new MyBinaryTree();
//BT.add(9);
//BT.add(4);
//BT.add(10);
//BT.add(21);
//BT.add(2);
//BT.add(8);
//BT.add(3);
//
//return BT;
//	}

//	Scanner input = new Scanner(System.in);


//
// if (input.hasNextLine()) {
//        String userInput = input.nextLine();
//        String[] array = userInput.split("\\s+");
//        int[] integerArray = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            integerArray[i] = Integer.parseInt(array[i]);
//        }
//        BTNode[] nodes = new BTNode[integerArray.length];
//        for(int i = 0; i < integerArray.length; i++) {
//        	nodes[i] = new BTNode();
//        }
//        for(int i = 0; i < integerArray.length; i++) {
//        	nodes[i].key = integerArray[i];
//        }		 
//	
// }



/*BTNode root = new BTNode();
BTNode rChildRoot = new BTNode();
// int key, BTNode parent, BTNode left, BTNode right
BTNode lChildRoot = new BTNode(20,root,null,rChildRoot);
root.setKey(25);
root.setRight(rChildRoot);
rChildRoot.setKey(27);
rChildRoot.setParent(root);

System.out.println(lChildRoot.right);
System.out.println("MyBinaryTree");
System.out.println(root.key);
System.out.println(rChildRoot.parent);*/