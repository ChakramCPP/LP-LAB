	/*
	 * 
	Grammar 
	S -> F
	S -> ( S + F )
	F -> a

	*/
	import java.io.*;
	import java.util.*;

public class RecursiveDescent {
		public String input;
		Stack<Character> stack = new Stack<Character>();
		char[] t=new char[4];
		char[] nt=new char[2];
		int ptr=0,max;
		char temp;
	public static void main(String args[]) throws IOException
	{
		RecursiveDescent ll=new RecursiveDescent();
		ll.check();
	}

	RecursiveDescent() throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		input=bf.readLine();
		t[0]='a';t[1]='(';t[2]=')';t[3]='+';
		nt[0]='S';
		nt[1]='F';
		max=input.length();
	}

	public void check()
	{
		stack.push('S');
		while(!stack.empty())
		{
			temp=stack.pop();
			if(temp==nt[0] || temp==nt[1])
			{
				NT();
			}
			else if(temp==t[0] || temp==t[1] ||temp==t[2] ||temp==t[3])
			{
			   T();
			}
			else
			{
				System.out.println("Input Symbols Not Available in Grammar");
				System.exit(0);
			}
		}
		
		if(max==ptr)
		{
			System.out.println("Input String Accepted");
		}
		else
		{
			System.out.println("Input String not Satisfied by the above Grammar");
			System.exit(0);
		}
	}

	public void NT()
	{
		if(temp=='S')
		{
			char c = input.charAt(ptr);
			if(c=='(')
			{
				stack.push(')');
				stack.push('F');
				stack.push('+');
				stack.push('S');
				stack.push('(');
			}
			else stack.push('F');
		}
		
		if(temp=='F')
		{
			stack.push('a');
		}
		
	}

	public void T()
	{
		char c = input.charAt(ptr);
		if(temp==c)
		{
			ptr++;
		}
		else 
		{
			System.out.println("Input String not Satisfied by the above Grammar");
			System.exit(0);
		}
			
	}




}
