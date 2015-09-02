import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Dictionary {
	
	private AVLTree dic = new AVLTree();
	
	public void loadDictionary(){
		
		Scanner s=null ;
		
		try {
			 s = new Scanner(new File("./dictionary.txt"));
			while(s.hasNext())
			{
				try{
					dic.insert(s.nextLine());
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
				System.out.println("ERROR: Word already in the dictionary!");
			}
			}		
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not Found");
		}
		 
		
		System.out.println("Dictionary Size : "+dic.size()+" Height : "+dic.height());
		s.close();
	}
	
	public void printSize(){
		System.out.println(dic.size() +" word");
	}
	
	public void insertWord(String s)
	{
		try{
		
			dic.insert(s);
		}catch(Exception e)
		{
			System.out.println("ERROR: Word already in the dictionary!");
		}
		System.out.println("Dictionary Size : "+dic.size()+" Height : "+dic.height());
	}
	
	public void lookUp(String s)
	{
		if(dic.search(s)==null)
			System.out.println("NO");
		else
			System.out.println("YES");
		
	}
	
	public void removeWord(String s)
	{
		try{
			dic.delete(s);
			
		}catch(Exception e)
		{
			System.out.println("ERROR : The Word '"+s+"' is not in the dictionary !");
		}
		System.out.println("Dictionary Size : "+dic.size()+" Height : "+dic.height());
		
	}
	public void batchLookUps()
	{
		Scanner s =null ;
		int c = 0;
		String temp ;
		try{
			
			s = new Scanner(new File("./queries.txt"));
			while(s.hasNext())
			{
				temp = s.nextLine();
				if(dic.search(temp)!=null)
				{
					System.out.println(temp+" --> YES");
					c++;
				}
				else
					System.out.println(temp+" --> NO");
			}
			
		}catch(Exception e)
		{
			
			System.out.println("File Not Found !");
		}
		
		System.out.println("The total number of found words = "+c);
		s.close();
	}
	
	public void batchDeletions()
	{
	
		
		Scanner s =null ;
		String st;
		try{
			
			s = new Scanner(new File("./deletions.txt"));
			while(s.hasNext())
			{
				st = s.nextLine();
				try{
					dic.delete(st);
					
				}catch(Exception e)
				{
					System.out.println("ERROR : The Word '"+st+"' is not in the dictionary !");
				}
			}
			
		}catch(Exception e)
		{
			
			System.out.println("File Not Found !");
		}
		
		
		System.out.println("Dictionary Size : "+dic.size()+" Height : "+dic.height());
		s.close();
		
		
	}
	
	

}
