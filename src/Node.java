
public class Node  {

	private Comparable element ;
	private Node left , right ;
	private int height ;
	
	public Node (Comparable o ){
		element = o ;
	}
	
	public Node (Comparable o , Node left , Node right)
	{	
		this.element = o ;
		this.left = left ;
		this.right = right;
	}
	
	public Comparable getElement() {
		return element;
	}
	public void setElement(Comparable element) {
		this.element = element;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
