/*
 SLR for the Above Grammar
 
 C -> AB --- 1
 A -> a  --- 2
 B -> a  --- 3
 */

import java.io.*;
import java.util.*;

public class SLRparser 
{
	Stack<Character> stack = new Stack<Character>();
	public String input;
	public int count=0,l=0;
	public Character NT[]=new Character[3];
	public Character T[]=new Character[1];
	public String ar[][]=new String[6][5];
	public int c[]=new int[3];
	char[] c1;
	public Character temp;
	public static void main(String args[])
	{
		SLRparser slr=new SLRparser();		
		slr.check();
	}
	
	SLRparser()
	{
		NT[0]='C';
		NT[1]='A';
		NT[2]='B';
		T[0]='a';
		for(int i=0;i<6;i++)
			for(int j=0;j<5;j++)
				ar[i][j]="=";
		
		ar[0][0]="S3";
		ar[0][2]="1";
		ar[0][3]="2";
		ar[2][0]="S5";
		ar[2][4]="4";
		ar[3][0]="r2";
		ar[4][1]="r1";
		ar[5][1]="r3";
		ar[1][1]="?";
		c[0]=2;
		c[1]=1;
		c[2]=1;
		Scanner sc=new Scanner(System.in);
		input=sc.nextLine();
		count=input.length();
		c1 = input.toCharArray();
		stack.push('0');
	}
	
	public void check()
	{
		if(c1[l]=='a')
		{
			if(ar[0][0].charAt(0)=='S')
			{
				Shift(ar[0][0].charAt(1));
				//System.out.println("Entered 1");
			}
			else if(ar[0][0].charAt(0)=='r')
			{
				Reduce(Character.getNumericValue(ar[0][0].charAt(1)));
				//System.out.println("Entered 2");
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
		int temp1=Character.getNumericValue(temp2);
		switch(c1[l])
		{
		case 'a' : 
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
				c2=stack.lastElement();
				stack.push('C');
				reducecompare(c2,'C');
				break;
			}
			
		case 2:
		{
			c2=stack.lastElement();
			stack.push('A');
			reducecompare(c2,'A');
			break;
		}
		
		case 3:
		{
			c2=stack.lastElement();
			stack.push('B');
			reducecompare(c2,'B');
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
		case 'C' :
			{
				stack.push(ar[a][2].charAt(0));
				break;
			}
			
		case 'A' :
		{
			stack.push(ar[a][3].charAt(0));
			break;
		}
		
		case 'B' :
		{
			stack.push(ar[a][4].charAt(0));
			break;
		}
			
		}
		
	}
}
