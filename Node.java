
public class Node {
	private Value value; // variable to hold a value
	private Node right, down; // pointers to right and down nodes
	// node constructor takes a value as an argument
	public Node(Value value) {
		this.value = value;
	}
	// getter for right node
	public Node getRight() {
		return right;
	}
	// setter for right node
	public void setRight(Node right) {
		this.right = right;
	}
	// getter for down node
	public Node getDown() {
		return down;
	}
	// setter for down node
	public void setDown(Node down) {
		this.down = down;
	}
	// getter for value
	public Value getValue() {
		return value;
	}
	// setter for value
	public void setValue(Value value) {
		this.value = value;
	}
}