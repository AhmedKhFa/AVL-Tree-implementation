import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Dictionary dic = new Dictionary();
		
		while(true)
		{
			System.out.println("___________________________________\n1-Load Dictionary\n2-Print Dictionary size\n3-Insert Word\n4-Look-up a word\n5-Remove word\n6-Batch Look-ups\n7-Batch Deletions\n");
			String s ;
			int ch = Integer.parseInt(sc.nextLine());
			switch (ch)
			{
				case 1 :
					dic.loadDictionary();
					break ;
					
				case 2 :	
					dic.printSize();
					break;
				
				case 3 :
					 s = sc.nextLine();
					dic.insertWord(s);
					break;
				
				case 4 :
					 s = sc.nextLine();
					dic.lookUp(s);
					break;
				case 5 :
					s = sc.nextLine();
					dic.removeWord(s);
					break;
				case 6:
					dic.batchLookUps();
					break;
				case 7:
					dic.batchDeletions();
					break;
			}
			
		}
	}

}
