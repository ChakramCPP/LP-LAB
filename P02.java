//RECURSIVE DESCENT PARSER
import java.io.*;
import java.util.*;
import java.math.*;
class P02
{
static int i=0,j=0;
static String inp,la,out="";
public static void main(String args[])
{
long b=System.currentTimeMillis();
Scanner sc=new Scanner(System.in);
inp=sc.next();
//inp+=" ";
la=""+inp.charAt(i);
E();
error();
}
public static void E()
{
T();
while(true)
{
if(la.equals("+"))
{
match("+");
T();
out+="+ ";
//System.out.print("+ ");
}
else if(la.equals("-"))
{
match("-");
T();
out+="- ";
//System.out.print("- ");
}
else if(i==inp.length())
{
System.out.println(out);
System.exit(0);
}
else
break;
}
}
public static void T()
{
if(la.equals("0"))
{
match("0");
out+="0 ";
//System.out.print("0 ");
}
else if(la.equals("1"))
{
match("1");
out+="1 ";
//System.out.print("1 ");
}
else if(la.equals("2"))
{
match("2");
out+="2 ";
//System.out.print("2 ");
}
else if(la.equals("3"))
{
match("3");
out+="3 ";
//System.out.print("3 ");
}
else if(la.equals("4"))
{
match("4");
out+="4 ";
//System.out.print("4 ");
}
else if(la.equals("5"))
{
match("5");
out+="5 ";
//System.out.print("5 ");
}
else if(la.equals("6"))
{
match("6");
out+="6 ";
//System.out.print("6 ");
}
else if(la.equals("7"))
{
match("7");
out+="7 ";
//System.out.print("7 ");
}
else if(la.equals("8"))
{
match("8");
out+="8 ";
//System.out.print("8 ");
}
else if(la.equals("9"))
{
match("9");
out+="9 ";
//System.out.print("9 ");
}
else
{
j++;
error();
}
}
public static void match(String s)
{
if(s.equals(la))
{
i++;
if(i<inp.length())
la=""+inp.charAt(i);
}
else
{
j++;
error();
}
}
public static void error()
{
System.out.println("ERROR!!!!");
System.exit(0);
}
}