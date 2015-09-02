import java.util.Stack;


public class InOrderWalk {

	
	// Non - recursive inorder walk algorithm
	
	public void inOrder(Node root)
	{
		Node p = root;
		Stack s = new Stack();
		
		
		do{
			
			while(p!=null)
			{
				s.push(p);
				p=p.getLeft();				
			}
			
			p=(Node)s.pop();
			System.out.println(p.getElement());
			p=p.getRight();

		}while(p!=null || !s.isEmpty());
	}
}
