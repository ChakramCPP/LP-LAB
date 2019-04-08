/* Grammar
 E  -> TZ      ---1
 Z -> +TZ     ---2
 Z -> ?        ---3
 T  -> FR      ---4
 R -> * FR	---5  
 R -> ?	---6
 F  -> d		---7
 F  -> ( E )	---8
  
 */



import java.util.*;
import java.io.*;
	
public class LLparser {
	
	Stack<Character> stack = new Stack<Character>();
	public String input;
	public int count=0,l=0;
	public Character NT[]=new Character[5];
	public Character T[]=new Character[6];
	public Character ar[][]=new Character[5][6];
	
	
	public static void main(String args[])
	{
		LLparser ll=new LLparser();		
		ll.check();
	}
	
	
	
	LLparser()
	{
		for(int i=0;i<5;i++)
			for(int j=0;j<6;j++)
				ar[i][j]='-';
		ar[0][2]='1';
		ar[0][3]='1';
		ar[1][0]='2';
		ar[1][4]='3';
		ar[1][5]='3';
		ar[2][2]='4';
		ar[2][3]='4';
		ar[3][0]='6';
		ar[3][1]='5';
		ar[3][4]='6';
		ar[3][5]='6';
		ar[4][2]='7';
		ar[4][3]='8';
		NT[0]='E';
		NT[1]='Z';
		NT[2]='T';
		NT[3]='R';
		NT[4]='F';
		T[0]='+';
		T[1]='*';
		T[2]='d';
		T[3]='(';
		T[4]=')';
		T[5]='$';
		Scanner sc=new Scanner(System.in);
		input=sc.nextLine();
		l=input.length();
	}

	void Push(char s)
	{
		switch(s)
		{
			case '1':
					{
						stack.push('Z');
						stack.push('T');
						break;
					}
					
			case '2':
					{
						stack.push('Z');
						stack.push('T');
						stack.push('+');
						break;
					}
			
			case '3':
					{
						stack.push('?');
						break;
					}
			
			case '4':
					{
						stack.push('R');
						stack.push('F');
						break;
					}
			
			case '5':
					{
						stack.push('R');
						stack.push('F');
						stack.push('*');
						break;
					}
			
			case '6':
					{
						stack.push('?');
						break;
					}
			
			case '7':
					{
						stack.push('d');
						break;
					}
			
			case '8':
					{
						stack.push('(');
						stack.push('E');
						stack.push(')');
						break;
					}
					
			default: break;
			
			
		}
	}
	
	void check()
	{
		stack.push('$');
		stack.push('E');
		char[] c = input.toCharArray();
		int i=0,j,k=0;
		char temp,temp1 = 0;
		while(!stack.isEmpty())
		{
			temp=stack.pop();
			if(temp=='?')
				continue;
			//System.out.println(temp);
			if(i<l)
			temp1=c[i];
			else temp1='$';
			
			//System.out.println(temp1);
			
			for(j=0;j<5;j++)
			{
				if(temp==NT[j])
					break;
				else continue;
			}
			//System.out.println(j);
			if(j==5)
			{
					if(temp1==temp)
						{
						i++;
						}
					else 
					{
						System.out.println("Input String not accepted by the Given Grammar");
						System.exit(0);
					}
			}
			else if(j<5)
			{
				for(k=0;k<6;k++)
					{
					if(temp1==T[k])
						break;
					else continue;
					}
				//System.out.println(k);
					if(k<6)
					{
						if(ar[j][k]!='-')
						Push(ar[j][k]);
						else
						{
							System.out.println("Input String not accepted by the Given Grammar");
							System.exit(0);
						}
					}
						
					else 
						{
						System.out.println("Input String Not Accepted");
						System.exit(0);
						}
							
			}
			
		}
		
		//System.out.println(i);
		
		if(i==l+1 && stack.isEmpty())
			System.out.println("Input String Accepted");
		
	}
	
	
}
