/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author niall mulloy
 *
 *************************************************************************/


public class BST<Key extends Comparable<Key>, Value> {
	private Node root; // root of BST

	/**
	 * Private node class.
	 */
	private class Node {
		private Key key; // sorted by key
		private Value val; // associated data
		private Node left, right; // left and right subtrees
		private int N; // number of nodes in subtree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	// is the symbol table empty?
	public boolean isEmpty() {
		return size() == 0;
	}

	// return number of key-value pairs in BST
	public int size() {
		return size(root);
	}

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	/**
	 * Search BST for given key. Does there exist a key-value pair with given
	 * key?
	 *
	 * @param key
	 *            the search key
	 * @return true if key is found and false otherwise
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}

	/**
	 * Search BST for given key. What is the value associated with given key?
	 *
	 * @param key
	 *            the search key
	 * @return value associated with the given key if found, or null if no such
	 *         key exists.
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	/**
	 * Insert key-value pair into BST. If key already exists, update with new
	 * value.
	 *
	 * @param key
	 *            the key to insert
	 * @param val
	 *            the value associated with key
	 */
	public void put(Key key, Value val) {
		/*if (val == null) {
			delete(key);
			return ;
		}*/
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

	/**
	 * Tree height.
	 *
	 * Asymptotic worst-case running time using Theta notation: 
	 * 
	 * Answer : theta N
	 * 
	 * Workings: The function can only visit each node once so the slowest running time can only be the number of nodes it visits
	 *
	 * @return the number of links from the root to the deepest leaf.
	 *
	 *         Example 1: for an empty tree this should return -1. Example 2:
	 *         for a tree with only one node it should return 0. Example 3: for
	 *         the following tree it should return 2. B / \ A C \ D
	 */

	public int height(){
		return heightPrivate(root);
	}
	
	private int heightPrivate(Node enteredNode) {
		if (isEmpty() == true) {
			return -1;
		} else if (size(enteredNode) == 1) {
			return 0;
		} else {
			if (size(enteredNode.left) > size(enteredNode.right)) {
				return 1 + heightPrivate(enteredNode.left);
			} else {
				return 1 + heightPrivate(enteredNode.right);
			}

		}

	}

	/**
	 * Median key. If the tree has N keys k1 < k2 < k3 < ... < kN, then their
	 * median key is the element at position (N+1)/2 (where "/" here is integer
	 * division)
	 *
	 * @return the median key, or null if the tree is empty.
	 */


	public Key median() {
		if (isEmpty()) {
			return null;
		}
		else if(size(root) == 1){
			return root.key;
		}
		int medianPosition = (size(root) + 1) / 2;
		return medianPrivate(root, medianPosition);

	}
	public Key medianPrivate(Node enteredNode, int medianPosition) {
		int order = rank(enteredNode.key);
		if (order < medianPosition) {
			return medianPrivate(enteredNode.right, medianPosition);
		} else if (order > medianPosition) {
			
			return medianPrivate(enteredNode.left,medianPosition);
		} else {
			return enteredNode.key;
			
		}
	}

	// rank taken from vasilieos' slides
	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(key, x.left);
		else if (cmp > 0)
			return  size(x.left) + rank(key, x.right) + 1;
		else
			return size(x.left) + 1;
	}

	/**
	 * Print all keys of the tree in a sequence, in-order. That is, for each
	 * node, the keys in the left subtree should appear before the key in the
	 * node. Also, for each node, the keys in the right subtree should appear
	 * before the key in the node. For each subtree, its keys should appear
	 * within a parenthesis.
	 *
	 * Example 1: Empty tree -- output: "()" Example 2: Tree containing only "A"
	 * -- output: "(()A())" Example 3: Tree: B / \ A C \ D
	 *
	 * output: "((()A())B(()C(()D())))"
	 *
	 * output of example in the assignment:
	 * (((()A(()C()))E((()H(()M()))R()))S(()X()))
	 *
	 * @return a String with all keys in the tree, in order, parenthesized.
	 */
	public String printKeysInOrder() {
		if (isEmpty()) {
			return "()";
		} else {
			return "(" + printKeysInOrder(root) + ")";
		}

	}

	private String printKeysInOrder(Node enteredNode) {
		String answer = "";
		
			answer += "(";
			if (enteredNode.left != null) {
				answer += printKeysInOrder(enteredNode.left);
			}
			answer += ")" + enteredNode.key + "(";
			if (enteredNode.right != null) {
				answer += printKeysInOrder(enteredNode.right);
			}
			answer += ")";
		
		return answer;
	}

	/**
	 * Pretty Printing the tree. Each node is on one line -- see assignment for
	 * details.
	 *
	 * @return a multi-line string with the pretty ascii picture of the tree.
	 */
public String prettyPrintKeys() {
	  if (isEmpty())
	        {
	            return "-null\n";
	        }
		else{
			String answer = prettyPrintKeys(root,"") + "\n";
			return answer;
		}
	}

	public String prettyPrintKeys(Node enteredNode, String enteredString) {
		String answer = "";
		if(enteredNode == null){
			answer = enteredString + "-null";
		}
		else{
			answer = enteredString +  "-" + enteredNode.val + "\n" + prettyPrintKeys(enteredNode.left, enteredString + " |") + "\n" + prettyPrintKeys(enteredNode.right, enteredString + "  ");
		}
		return answer;
		}
	  
	/**
	 * Deteles a key from a tree (if the key is in the tree). Note that this
	 * method works symmetrically from the Hibbard deletion: If the node to be
	 * deleted has two child nodes, then it needs to be replaced with its
	 * predecessor (not its successor) node.
	 *
	 * @param key
	 *            the key to delete
	 */
    private Node deleteMax(Node theNode) {
        if (theNode.right == null){
        	return theNode.left;
        }
        theNode.right = deleteMax(theNode.right);
        theNode.N = size(theNode.left) + size(theNode.right) + 1;
        return theNode;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node theNode, Key key) {
        if (theNode == null){
        	return null;
        }

        int cmp = key.compareTo(theNode.key);
        if (cmp < 0){
        	theNode.left  = delete(theNode.left,  key);
        }
        else if (cmp > 0){
        	theNode.right = delete(theNode.right, key);
        }
        else { 
            if (theNode.right == null) {
            	return theNode.left;

            }
            	
           // if (theNode.left  == null) return theNode.right;
            
            Node highest = theNode;
            theNode = max(highest.left);
            theNode.left = deleteMax(highest.left);
            theNode.right = highest.right;
        } 
        theNode.N = size(theNode.left) + size(theNode.right) + 1;
        return theNode;
    } 
     
    private Node max(Node enteredNode) {
        if (enteredNode.right == null) {
        	return enteredNode; 
        }
        else{
        	return max(enteredNode.right); 
        }
    } 
}