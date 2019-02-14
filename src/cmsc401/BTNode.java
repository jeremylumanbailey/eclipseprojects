package cmsc401;

public class BTNode {
	
	BTNode()
	{

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
