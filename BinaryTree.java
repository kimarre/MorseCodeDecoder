/**
* @author Kim Arre
*/
public class BinaryTree<Element> {
    private BinaryNode<Element> current; // current location in the binary tree
    private BinaryNode<Element> root;    // root of binary tree

    /**
    * Finds parent by traversing the tree from the given parameter 'finder.' Once the element is
    * found, current is set to the parent.
    * @param finder Where the search for the parent begins
    */
    private void findParent(BinaryNode<Element> finder) {
        if(finder == null) {
            return;
        }
        if(current == root) {
            return;
        }
        if(finder.getLeft() == current) {
            current = finder;
        }
        else if(finder.getRight() == current){
            current = finder;
        }
        else {
            findParent(finder.getRight());
            findParent(finder.getLeft());
        }
    }

    /**
    * Inserts a new node onto the tree and makes it the new current node.
    * @param item     The node content to be put into the tree
    * @param where    The position, with respect to the current node that the new node may go. Must be a Relative.
    */
    public void insert(Element item, Relative where) {
        BinaryNode<Element> newNode = new BinaryNode<Element>(item);
        if(where == Relative.ROOT) {
            root = newNode;
            current = newNode;
        }
        else if(where == Relative.LEFT_CHILD) {
            current.setLeft(newNode);
            current = newNode;
        }
        
        else if(where == Relative.RIGHT_CHILD) {
            current.setRight(newNode);
            current = newNode;
        }
    }

    /** 
    * Checks that a tree is empty and returns the boolean result
    * @return     Returns the boolean result of checking if empty
    */
    public boolean isEmpty() {
        if(root == null) {
            return true;
        }
        return false;
    }

    /**
    * Empties the binary tree by setting the root node to null.
    */
    public void makeEmpty() {
        root = null;
    }

    /**
    * Moves current to the desired relative node.
    * @return    Returns the boolean for whether or not a tree move was successful.
    */
    public Boolean move(Relative where) {
        switch(where) {
        case PARENT:
            if(current == root) {
                return false;
            }
            findParent(root);
            return true;
        case LEFT_CHILD:
            if(current.getLeft() == null) {
                return false;
            }
            current = current.getLeft();
            return true;
        case RIGHT_CHILD:
            if(current.getRight() == null) {
                return false;
            }
            current = current.getRight();
            return true;
        case ROOT:
            current = root;
            return true;
        default:
            return false;
        }
    }
    
    /**
    * Finds the data within a given node and returns it.
    * @return    Returns the node content for the node it's called on.
    */
    public Element retrieve() {
        return current.getData();
    }
    
    /**
    * Calls the private method traverseTree(target) to return a string representation of the traversal.
    * @return    Returns a String of the tree's contents using pre-order traversal.
    */
    public String traverse() {
        return traverseTree(root);
    }

    /**
    * Uses pre-order traversal to work through the tree. Returns the string representation.
    * @return    Returns a String of the tree's contents using pre-order traversal.
    */
    private String traverseTree(BinaryNode<Element> target) {
        if(target == null) {
            return "";
        }
        return target.getData().toString() + traverseTree(target.getLeft()) + traverseTree(target.getRight());
    }

}



