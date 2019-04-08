//SYNTAX DIRECTED TREE PROGRAM -2
import java.io.*;
import java.util.*;
import java.lang.*;
class P09
{
static String in="";
public static void main(String args[])
{
long b=System.currentTimeMillis();
System.out.println("Enter the expression");
Scanner sc=new Scanner(System.in);
String in=sc.next();
System.out.println("Expression is "+in);
L l=new L(in);
System.out.println("Clean expression is "+l.ex);
}
}
class L
{
String ex="";
L(String s)
{
System.out.println("L-B "+s);
E e=new E(s);
if(e.w)
ex=e.c;
else
ex=e.ex;
System.out.println("L-E "+ex);
}
}
class E
{
String ex="",c="";
int p;
boolean w;
E(String s)
{
System.out.println("E-B "+s);
if(s.length()==1 ||(s.contains("(") && s.contains(")")))
{
T t=new T(s);
w=t.w;
p=t.p;
ex=t.ex;
c=t.c;
}
else if(s.contains("+"))
{
String v1="",v2="";
int i=0;
while((s.charAt(i)+"").compareTo("+")!=0)
{
v1+=s.charAt(i)+"";
i++;
}
E e1=new E(v1);
i++;
while(i<s.length())
{
v2+=s.charAt(i)+"";
i++;
}
T t=new T(v2);
w=false;
p=0;
ex=e1.ex+"+"+t.ex;
if(e1.w)
c=e1.c;
else
c=e1.ex;
c+="+";
if(t.w)
c+=t.c;
else
c+=t.ex;
}
System.out.println("E-E "+ex+" "+c+" "+p+" "+w);
}
}
class T
{
String ex="",c="";
int p;
boolean w;
T(String s)
{
Stack<Character> st=new Stack<Character>();
int i;
for(i=0;i<s.length();i++)
{
char ch=s.charAt(i);
if(ch=='(')
st.push(ch);
else if(ch==')')
st.pop();
if(st.isEmpty())
break;
}
System.out.println("T-B "+s+" "+i+" "+s.length());
if(s.length()==1 ||(i==s.length()-1))
{
F f=new F(s);
w=f.w;
p=f.p;
ex=f.ex;
c=f.c;
}
else if(s.contains("*"))
{
String v1="",v2="";
i=s.length()-1;
while((s.charAt(i)+"").compareTo("*")!=0)
{
v2=s.charAt(i)+""+v2;
i--;
}
i--;
while(i>=0)
{
v1=s.charAt(i)+""+v1;
i--;
}
T t1=new T(v1);
F f=new F(v2);
w=false;
p=1;
ex=t1.ex+"*"+f.ex;
if(t1.w && t1.p>=1)
c=t1.c;
else
c=t1.ex;
c+="*";
if(f.w && f.p>=1)
c+=f.c;
else
c+=f.ex;
}
System.out.println("T-E "+ex+" "+c+" "+p+" "+w);
}
}
class F
{
String ex="",c="";
int p;
boolean w;
F(String s)
{
System.out.println("F-B "+s);
if(s.contains("(") && s.contains(")"))
{
StringBuilder sb=new StringBuilder(s);
sb.deleteCharAt(0);
s=sb.toString();
sb=new StringBuilder(s);
sb.deleteCharAt(s.length()-1);
s=sb.toString();
E e=new E(s);
w=true;
p=e.p;
ex="("+e.ex+")";
c=e.c;
}
else if(s.length()==1)
{
w=false;
p=2;
ex=s;
c=s;
}
System.out.println("F-E "+ex+" "+c+" "+p+" "+w);
}
}