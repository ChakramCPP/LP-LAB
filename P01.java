//SPLIT A GIVEN JAVA PROGRAM TO TOKENS
//INPUT- In1.java
import java.io.*;
import java.util.*;
class P01
{
public static void main(String args[]) throws IOException
{
int c=0;
long b=System.currentTimeMillis();
Scanner sc=new Scanner(System.in);
String fn=sc.next();
BufferedReader br=new BufferedReader(new FileReader(fn));
String s="",s1=""; 
while ((s1 = br.readLine()) != null) 
{
//System.out.println(s1); 
s+=s1;
}
StringTokenizer st1=new StringTokenizer(s,".",true);
s="";
while(st1.hasMoreTokens())
{
s1=st1.nextToken();
//System.out.println(s1);
s1=" "+s1;
s+=s1;
}
st1=new StringTokenizer(s,";",true);
s="";
while(st1.hasMoreTokens())
{
s1=st1.nextToken();
//System.out.println(s1);
s1=" "+s1;
s+=s1;
}
st1=new StringTokenizer(s,"{",true);
s="";
while(st1.hasMoreTokens())
{
s1=st1.nextToken();
//System.out.println(s1);
s1=" "+s1;
s+=s1;
}
st1=new StringTokenizer(s,"}",true);
s="";
while(st1.hasMoreTokens())
{
s1=st1.nextToken();
//System.out.println(s1);
s1=" "+s1;
s+=s1;
}
st1=new StringTokenizer(s,"(",true);
s="";
while(st1.hasMoreTokens())
{
s1=st1.nextToken();
//System.out.println(s1);
s1=" "+s1;
s+=s1;
}
st1=new StringTokenizer(s,")",true);
s="";
while(st1.hasMoreTokens())
{
s1=st1.nextToken();
//System.out.println(s1);
s1=" "+s1;
s+=s1;
}
s=s.trim().replaceAll("\\s{2,}", " ");
//System.out.println(s);
st1=new StringTokenizer(s," ");
while(st1.hasMoreTokens())
{
c++;
System.out.println(st1.nextToken());
}
System.out.println(c);
long e=System.currentTimeMillis();
System.out.println((e-b)*0.001);
sc.close();
}
}