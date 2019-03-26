package com.lax.codeexercise.tree;

public class BinaryTree {

	class Node {
		int iData;
		Node leftChild;
		Node rightChild;

		public Node(int data) {
			this.iData = data;
		}

	}

	private Node root;

	public Node find(int key) {
		Node current = root;
		while (current.iData != key) {
			if (key < current.iData) // go left?
				current = current.leftChild;
			else
				current = current.rightChild; // or go right?
			if (current == null) // if no child,
				return null; // didn't find it

		}
		return current;
	}

	public void insert(int id, double dd) {
		Node newNode = new Node(id); // make new node
		newNode.iData = id; // insert data
		if (root == null) // no node in root
			root = newNode;
		else // root occupied
		{
			Node current = root; // start at root
			Node parent;
			while (true) // (exits internally)
			{
				parent = current;
				if (id < current.iData) // go left?
				{
					current = current.leftChild;
					if (current == null) // if end of the line,
					{ // insert on left
						parent.leftChild = newNode;
						return;
					}
				} // end if go left
				else // or go right?
				{
					current = current.rightChild;
					if (current == null) // if end of the line
					{ // insert on right
						parent.rightChild = newNode;
						return;
					}
				} // end else go right
			} // end while
		} // end else not root
	} // end insert()

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);

			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}

	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

	private Node lowestCommonAncestor(Node r, int n1, int n2) {
		if (r == null ) return null;
		if (r.iData > n1 && r.iData > n2) {
			return lowestCommonAncestor(r.leftChild,n2, n2);
		}
		else
			if (r.iData < n1 && r.iData < n2) {
				return lowestCommonAncestor(r.rightChild,n2, n2);
			}
		return r;
	}
	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree();

		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		
		Node n = theTree.lowestCommonAncestor(theTree.root, 26, 43);
		System.out.println("Ancestor " + n.iData);
		
		theTree.inOrder(theTree.root);
		System.out.println();
		theTree.preOrder(theTree.root);
		System.out.println();
		theTree.postOrder(theTree.root);

	}

	
}
