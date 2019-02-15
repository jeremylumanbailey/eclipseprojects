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
      String line = input.nextLine();
      String[] arr = line.split("\\s+");
      int[] vals = new int[arr.length];
      for (int i = 0; i < arr.length; i++) {
          vals[i] = Integer.parseInt(arr[i]);
          
      }
      input.close();
      makeBinaryTree(vals);
		 }	 
	}
	
	public static void makeBinaryTree(int[] arr) {	
		
	    MyBinaryTree BT = new MyBinaryTree();
	    
	    for (int i = 0; i < arr.length; i++) {
	          BT.add(arr[i]);
	      }
	    BT.inOrder();
	    
	}
	
	
	BTNode addRecursive(BTNode currentNode, int newNum) {
		if(currentNode == null) {
			return new BTNode(newNum);
		}
		
		if(newNum < currentNode.key) {
			currentNode.left = addRecursive(currentNode.left, newNum);
		}
		else if (newNum > currentNode.key) {
			currentNode.right = addRecursive(currentNode.right, newNum);
		}
		else {
			return currentNode;
		}
		
		return currentNode;
	}
	
	// This method will add a new integer number into the binary search tree
	void add(int newNum) {
	
		root = addRecursive(root, newNum);
		
	}
	
	private int findSmallestValue(BTNode root) {
	    return root.left == null ? root.key : findSmallestValue(root.left);
	}
	
	//delete?
	BTNode deleteRecursive(BTNode current, int delNum) {
	    if (current == null) {
	        return null;
	    }
	 
	    if (delNum == current.key) {
	        // Node to delete found
	        // ... code to delete the node will go here
	    	
	    	if (current.left == null && current.right == null) {
	    	    return null;
	    	}
	    	
	    	if (current.right == null) {
	    	    return current.left;
	    	}
	    	 
	    	if (current.left == null) {
	    	    return current.right;
	    	}
	    	
	    	
	    	int smallestValue = findSmallestValue(current.right);
	    	current.key = smallestValue;
	    	current.right = deleteRecursive(current.right, smallestValue);
	    	return current;
	    	
	    	
	    } 
	    if (delNum < current.key) {
	        current.left = deleteRecursive(current.left, delNum);
	        return current;
	    }
	    current.right = deleteRecursive(current.right, delNum);
	    return current;
	}
	
	//Delete the number delNum if it exists. Return true if
		//	succeeds and or return false if the number does not exist.
	 boolean delete(int delNum) {
		 
		    root = deleteRecursive(root, delNum);
		   return true;
		    
	}
	
	 // Check whether the tree contains the number num or not.	
	 boolean contains(int num) {
		return containsNodeRecursive(root, num);
	 }
	
	 private boolean containsNodeRecursive(BTNode currentNode, int num) {
		if(currentNode == null) {
			return false;
		}
		if(num == currentNode.key) {
			return true;
		}
		return num < currentNode.key
				? containsNodeRecursive(currentNode.left, num)
				: containsNodeRecursive(currentNode.right, num);
	}
	 
	 
	 
	 
	 public void traverseInOrder(BTNode node) {
		    if (node != null) {
		        traverseInOrder(node.left);
		        System.out.print(" " + node.key);
		        traverseInOrder(node.right);
		    }
		}

	 public void traversePreOrder(BTNode node) {
		    if (node != null) {
		        System.out.print(" " + node.key);
		        traversePreOrder(node.left);
		        traversePreOrder(node.right);
		    }
		}
	 
	 public void traversePostOrder(BTNode node) {
		    if (node != null) {
		        traversePostOrder(node.left);
		        traversePostOrder(node.right);
		        System.out.print(" " + node.key);
		    }
		}


	// Return the preorder traversal result (numbers are separated by spaces)
		 
	 String inOrder() {
		traverseInOrder(root);
		 
		 return "";
	 }
	 
	 // Return the preorder traversal result (numbers are separated by spaces)
	 String preOrder() {
		 traversePreOrder(root);
		 return "";
	 }
	 
	// Return the postorder traversal result (numbers are separated by spaces)
	 String postOrder() {
		 traversePostOrder(root);
		 return "";
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
//        String line = input.nextLine();
//        String[] arr = line.split("\\s+");
//        int[] vals = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            vals[i] = Integer.parseInt(arr[i]);
//        }
//        BTNode[] nodes = new BTNode[vals.length];
//        for(int i = 0; i < vals.length; i++) {
//        	nodes[i] = new BTNode();
//        }
//        for(int i = 0; i < vals.length; i++) {
//        	nodes[i].key = vals[i];
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