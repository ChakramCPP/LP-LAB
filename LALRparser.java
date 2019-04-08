/*
 LALR for the Above Grammar
 
 S -> L=R 	--- 1
 S -> R  	--- 2
 L -> *R  	--- 3
 L -> d		--- 4
 R -> L		--- 5
 
 */

import java.io.*;
import java.util.*;

public class LALRparser 
{
	Stack<Character> stack = new Stack<Character>();
	public String input;
	public int count=0,l=0;
	public String ar[][]=new String[14][7];
	public int c[]=new int[5];
	char[] c1;
	public Character temp;
	public static void main(String args[])
	{
		LALRparser lalr=new LALRparser();		
		lalr.check();
	}
	
	LALRparser()
	{
		for(int i=0;i<14;i++)
			for(int j=0;j<7;j++)
				ar[i][j]="?";
		
		ar[0][1]="S4";
		ar[0][2]="S5";
		ar[0][4]="1";
		ar[0][5]="2";
		ar[0][6]="3";
		ar[2][0]="S6";
		ar[3][3]="r2";
		ar[4][1]="S4";
		ar[4][2]="S5";
		ar[4][5]="8";
		ar[4][6]="7";
		ar[5][0]="r4";
		ar[6][1]="S12";
		ar[6][2]="S11";
		ar[6][5]="9";
		ar[6][6]="10";
		ar[7][0]="r3";
		ar[8][0]="r5";
		ar[9][3]="r5";
		ar[10][3]="r1";
		ar[11][3]="r4";
		ar[12][1]="S12";
		ar[12][2]="S11";
		ar[12][5]="9";
		ar[12][6]="13";
		ar[13][3]="r3";
		c[0]=3;
		c[1]=1;
		c[2]=2;
		c[3]=1;
		c[4]=1;
		
		for(int i=0;i<14;i++)
		{
			for(int j=0;j<7;j++)
				{
				System.out.print(ar[i][j]+" ");
				}
			System.out.println();
		}
			
		
		Scanner sc=new Scanner(System.in);
		input=sc.nextLine();
		count=input.length();
		c1 = input.toCharArray();
		stack.push('0');
	}
	
	public void check()
	{
		if(c1[l]=='=')
		{
			if(ar[0][0].charAt(0)=='S')
			{
				Shift(ar[0][0].charAt(1));
				System.out.println("Entered 1");
			}
			else if(ar[0][0].charAt(0)=='r')
			{
				Reduce(Character.getNumericValue(ar[0][0].charAt(1)));
				System.out.println("Entered 2");
			}
				
		}
		
		else if(c1[l]=='*')
		{
			if(ar[0][1].charAt(0)=='S')
			{
				Shift(ar[0][1].charAt(1));
				System.out.println("Entered 3");
			}
			else if(ar[0][1].charAt(0)=='r')
			{
				Reduce(Character.getNumericValue(ar[0][1].charAt(1)));
				System.out.println("Entered 4");
			}
				
		}
		
		else if(c1[l]=='d')
		{
			if(ar[0][2].charAt(0)=='S')
			{
				Shift(ar[0][2].charAt(1));
				System.out.println("Entered 5");
			}
			else if(ar[0][2].charAt(0)=='r')
			{
				Reduce(Character.getNumericValue(ar[0][2].charAt(1)));
				System.out.println("Entered 6");
			}
				
		}
		
		while(l<count)
		{
			temp=stack.lastElement();
			if(temp=='1' && c1[l]=='$')
			{
				System.out.println("String is Accepted by the Given Grammar");
				System.exit(0);
			}
			compare();
		}
	}
	
	public void compare()
	{
		Character temp2;
		temp2=stack.lastElement();
		//System.out.println(temp2);
		int temp1=Character.getNumericValue(temp2);
		switch(c1[l])
		{
		case '=' : 
			{
				if(ar[temp1][0].charAt(0)=='S')
					Shift(ar[temp1][0].charAt(1));
				else if(ar[temp1][0].charAt(0)=='r')
					Reduce(Character.getNumericValue(ar[temp1][0].charAt(1)));
				else if (ar[temp1][0].charAt(0)=='=')
				{
					System.out.println("The Input String is not Accepted by the Given Grammar");
					System.exit(0);
				}
				break;
					
			}
			
		case '$' : 
			{
				if(ar[temp1][3].charAt(0)=='S')
					Shift(ar[temp1][3].charAt(1));
				else if(ar[temp1][3].charAt(0)=='r')
					Reduce(Character.getNumericValue(ar[temp1][3].charAt(1)));
				else if (ar[temp1][3].charAt(0)=='=')
				{
					System.out.println("The Input String is not Accepted by the Given Grammar");
					System.exit(0);
				}
				break;
			}
			
		case 'd' : 
		{
			if(ar[temp1][2].charAt(0)=='S')
				Shift(ar[temp1][2].charAt(1));
			else if(ar[temp1][2].charAt(0)=='r')
				Reduce(Character.getNumericValue(ar[temp1][2].charAt(1)));
			else if (ar[temp1][2].charAt(0)=='=')
			{
				System.out.println("The Input String is not Accepted by the Given Grammar");
				System.exit(0);
			}
			break;
			
		}
		
		case '*' : 
		{
			if(ar[temp1][1].charAt(0)=='S')
				Shift(ar[temp1][1].charAt(1));
			else if(ar[temp1][1].charAt(0)=='r')
				Reduce(Character.getNumericValue(ar[temp1][1].charAt(1)));
			else if (ar[temp1][1].charAt(0)=='=')
			{
				System.out.println("The Input String is not Accepted by the Given Grammar");
				System.exit(0);
			}
			break;
		}
		
		}
		
		
	}
	
	
	public void Shift(char k)
	{
		stack.push(c1[l]);
		l=l+1;
		stack.push(k);
	}
	
	public void Reduce(int k)
	{
		Character c2;
		for(int i=0;i<2*c[k-1];i++)
		{
			c2=stack.pop();
		}
		
		switch(k)
		{
		case 1:
			{
				c2=stack.pop();
				stack.push(c2);
				stack.push('S');
				reducecompare(c2,'S');
				break;
			}
			
		case 2:
		{
			c2=stack.pop();
			stack.push(c2);
			stack.push('S');
			reducecompare(c2,'S');
			break;
		}
		
		case 3:
		{
			c2=stack.pop();
			stack.push(c2);
			stack.push('L');
			reducecompare(c2,'L');
			break;
		}
		
		case 4:
		{
			c2=stack.pop();
			stack.push(c2);
			stack.push('L');
			reducecompare(c2,'L');
			break;
		}
		
		case 5:
		{
			c2=stack.pop();
			stack.push(c2);
			stack.push('R');
			reducecompare(c2,'R');
			break;
		}
	
		default: break;
		}
		
	}
	
	public void reducecompare(Character k,Character ch)
	{
		int a=Character.getNumericValue(k);
		switch(ch)
		{
		case 'S' :
			{
				stack.push(ar[a][4].charAt(0));
				break;
			}
			
		case 'L' :
		{
			stack.push(ar[a][5].charAt(0));
			break;
		}
		
		case 'R' :
		{
			stack.push(ar[a][6].charAt(0));
			break;
		}
			
		}
		
	}
}