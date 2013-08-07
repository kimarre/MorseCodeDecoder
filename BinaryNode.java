/**
* @author Kim Arre
*
*/
public class BinaryNode<T> {
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	private T nodeData;

	BinaryNode(T data, BinaryNode<T> l, BinaryNode<T> r) {
		left = l;
		right = r;
		nodeData = data;
	}

	BinaryNode(T data) {
		left = null;
		right = null;
		nodeData = data;
	}
	
	/**
	* Returns the left binary node.
	* @return Returns the binary node located to the left of the node called on.
	*/
	public BinaryNode<T> getLeft() {
		return left;
	}
	
	/**
	* Returns the right binary node.
	* @return Returns the binary node located to the right of the node called on.
	*/
	public BinaryNode<T> getRight() {
		return right;
	}
	
	/**
	* Sets the left binary node.
	* @param node    The node to be placed as the left child of current.
	*/
	public void setLeft(BinaryNode<T> node) {
		left = node;
	}
	
	/**
	* Sets the right binary node.
	* @param node    The node to be placed as the right child of current.
	*/
	public void setRight(BinaryNode<T> node) {
		right = node;
	}
	
	/**
	* Sets the data of the current binary node.
	* @param item    The item to be placed into a given node.
	*/
	public void setData(T item) {
		nodeData = item;
	}
	
	/**
	* Retrieves the data of the current binary node.
	* @return Returns the data of the current binary node.
	*/
	public T getData() {
		return nodeData;
	}
	
	
}