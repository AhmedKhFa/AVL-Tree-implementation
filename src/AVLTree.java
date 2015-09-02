
public class AVLTree  {

	private Node root ;
	private int size  ;
	

	
	/***************** size & height ************/
	public int height()
	{
		if(size==0)
			return 0;
		
		return root.getHeight() ;
	}
	
	public int size()
	{
		return size ;
	}
	
	/****************** Deletion  ***************/
	public void delete(Comparable o) throws Exception
	{
		 root = delete(root,o);
		 size--;
	}
	
	private Node delete(Node n , Comparable o) throws Exception
	{
		
		if(n==null)
			throw new Exception("Not Found !"); ;
		
		int r = n.getElement().compareTo(o);
		
		if(r<0)
			n.setRight(delete(n.getRight(),o));
		
		else if(r>0)
			n.setLeft(delete(n.getLeft(),o));
			
		else
		{
			if(n.getLeft()==null || n.getRight()==null) // zero or one child 
			{
				
				if(n.getLeft()!=null)
					n = n.getLeft();
				
				else if(n.getRight() != null)
					n = n.getRight();
				
				else // no child
					return n=null;
					
				
			}
			else // two children
			{	
				Node successor = getMin(n.getRight());
				n.setRight(delete(n.getRight(),successor.getElement()));
				
				successor.setRight(n.getRight());
				successor.setLeft(n.getLeft());
				n = successor ;
				
			}
		}
		
		
		
		n.setHeight(height(n));
		return balance(n);
		
	}
	
	private Node getMin(Node n)
	{
		Node temp = n ;
		while(temp.getLeft()!=null)
			temp =temp.getLeft();
		
		return temp ;
	}
	/****************** searching **************/
	public Node search(Comparable o) 
	{
		return find(root , o) ;
	}
	
	private Node find(Node n , Comparable o)
	{
		if(n==null)
			return null ;
		
		int r = n.getElement().compareTo(o);
		
		if(r>0)
		  return find(n.getLeft(),o); 
		
		else if(r<0)
		  return find(n.getRight(),o);
		
		else
			return n ;
				
	}
	
	
    /***************** insertion ********************/
	public void insert(Comparable o) throws Exception
	{
			root = add(root , o);
			size++;
	}
	
	private Node add(Node n , Comparable o) throws Exception
	{
		if(n==null)
			return  new Node(o);
		
		int r = n.getElement().compareTo(o);
		
		if(r>0)
		 n.setLeft(add(n.getLeft(),o)); 
		
		else if(r<0)
		  n.setRight(add(n.getRight(),o));
		
		else
			throw new Exception("Duplicate !");
		
		n.setHeight(height(n));
		return balance(n) ;
	}
	
	
	/**************** balancing methods ****************/
	private Node balance(Node n)
	{
		
		int balanceFactor = height(n.getLeft()) - height(n.getRight());
		Node temp  = n ;
		if(balanceFactor < -1) // right
		{
			balanceFactor = height(n.getRight().getLeft()) - height(n.getRight().getRight());
			if(balanceFactor < 0) // right
			    temp =  rightSingleRotation(n); 
				
			else // left
				temp =  rightDoubleRotation(n); 
				
		}
		
		else if(balanceFactor >1) // left
		{	
			balanceFactor = height(n.getLeft().getLeft()) - height(n.getLeft().getRight());
			if(balanceFactor<0) // right
			   temp = leftDoubleRotation(n);
			
			else   //left
 			    temp =  leftSingleRotation(n);	
		}
		
		
		
		return temp ;
	
	}
	
	
	private int height(Node n)
	{
		if(n == null)
			return -1 ;
		
		int left = -1, right = -1 ;
		
		if(n.getLeft()!=null)
			left = n.getLeft().getHeight();
		
		if(n.getRight() != null)
			right = n.getRight().getHeight();
		
		return Math.max(left,right)+1;
	}

	
	/************* Rotations *****************/
	
	private Node leftSingleRotation(Node n )
	{
		Node temp = n.getLeft();
		n.setLeft(temp.getRight());
		temp.setRight(n);
		
		n.setHeight(height(n));
		temp.setHeight(height(temp));
		
		
		return temp ;
	}
	private Node rightSingleRotation(Node n)
	{
		Node temp = n.getRight();
		n.setRight(temp.getLeft());
		temp.setLeft(n);
		
		n.setHeight(height(n));
		temp.setHeight(height(temp));
		
		return temp ;
	}
	
	private Node leftDoubleRotation(Node n )
	{

		
		n.setLeft(rightSingleRotation(n.getLeft()));
		return leftSingleRotation(n); 
		
	}
	
	private Node rightDoubleRotation(Node n )
	{
		n.setRight(leftSingleRotation(n.getRight()));
		return rightSingleRotation(n);
	}
	
	/********************* printing the tree ***************************/
	public void print()
	{
		print(root);
	}
	
	private void  print(Node n)
	{
		if (n== null)
			return ;
		
		print(n.getLeft());
		System.out.print(" "+n.getElement()+"h"+n.getHeight());
		print(n.getRight());
	}
	
}
