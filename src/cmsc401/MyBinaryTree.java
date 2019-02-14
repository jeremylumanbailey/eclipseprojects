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

public class MyBinaryTree {
	
	class BTNode {
		int key;
		BTNode parent;
		BTNode left;
		BTNode right;
		} 

	public static void main(String[] args) {
		
		System.out.println("MyBinaryTree");
		

	}
	
	// This method will add a new integer number into the binary search tree
	void add(int newNum) {
		
		
	}
	
	//Delete the number delNum if it exists. Return true if
		//	succeeds and or return false if the number does not exist.
	 boolean delete(int delNum) {
	
	
		
		return false;
	}
	
	 // Check whether the tree contains the number num or not.	
	 boolean contains(int num) {
		
		 return false;
	 }
	
	 // Return the preorder traversal result (numbers are separated by spaces)
		 
	 String inOrder() {
		 
		 return "String";
	 }
	 
	 // Return the preorder traversal result (numbers are separated by spaces)
	 String preOrder() {
		 
		 return "String";
	 }
	 
	// Return the postorder traversal result (numbers are separated by spaces)
	 String postOrder() {
		 
		 return "String";
	 }
	 
	 
}
