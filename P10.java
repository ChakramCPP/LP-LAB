//Intermediate code generation for arrays addition
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
class P10
{
public static void main(String args[])
{
long b=System.currentTimeMillis();
Scanner sc=new Scanner(System.in);
String st=sc.next();
int j=1;
S s=new S(st,j);
long e=System.currentTimeMillis();
System.out.println((e-b)*0.001);
}
}
class S
{
String ex="";
static int j=1;
S(String st,int k)
{
j=k;
System.out.println("S-B "+st);
if(st.contains("="))
{
String st1="",st2="",v=st.charAt(0)+"";
int i=0;
while(!v.equals("="))
{
st1+=v;
i++;
v=st.charAt(i)+"";
}
i++;
while(i<st.length())
{
v=st.charAt(i)+"";
st2+=v;
i++;
}
L l=new L(st1,j);
j=l.j;
E e=new E(st2,j);
j=e.j;
if(l.o!=null)
ex=l.p+"="+e.p+"\n";
else
ex=l.p+"["+l.o+"]="+e.p+"\n";
}
System.out.println("S-E "+ex);
}
}
class L
{
String p="",o="",ex="";
static int j=1;
L(String st,int k)
{
j=k;
System.out.println("L-B "+st);
if(st.length()==1)
{
p=st;
o=null;
}
else
{
StringBuilder sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
El el=new El(st,j);
j=El.j;
p="t"+j;
j++;
o="t"+j;
j++;
ex=p+"="+el.a+"\n";
ex+=o+"="+el.p+"*width("+el.a+")"+"\n";
}
System.out.println("L-E "+ex+" "+p+" "+o);
}
}
class E
{
String p="",ex="";
static int j=1;
E(String st,int k)
{
j=k;
System.out.println("E-B "+st);
if(st.contains("(") && st.contains(")"))
{
StringBuilder sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
sb.deleteCharAt(0);
st=sb.toString();
E e1=new E(st,j);
j=e1.j;
p=e1.p;
}
else if(st.contains("+"))
{
String st1="",st2="",v=st.charAt(0)+"";
int i=0;
while(!v.equals("+"))
{
st1+=v;
i++;
v=st.charAt(i)+"";
}
i++;
while(i<st.length())
{
v=st.charAt(i)+"";
st2+=v;
i++;
}
E e1=new E(st1,j);
j=e1.j;
E e2=new E(st2,j);
j=e2.j;
p="t"+j;
j++;
ex=p+"="+e1.p+"+"+e2.p+"\n";
}
else
{
L l=new L(st,j);
j=l.j;
if(l.o==null)
p=l.p;
else
{
p="t"+j;
ex=p+"="+l.p+"["+l.o+"]"+"\n";
}
j++;
}
System.out.println("E-E "+ex+" "+p);
}
}
class El
{
String a="",p="",ex="";
static int ndim=0,j=1;
El(String st,int k)
{
j=k;
System.out.println("El-B "+st);
if(st.contains(","))
{
String st1="",st2="",v=st.charAt(st.length()-1)+"";
int i=st.length()-1;;
while(!v.equals(","))
{
st2=v+st2;
i--;
v=st.charAt(i)+"";
}
i--;
while(i>=0)
{
v=st.charAt(i)+"";
st1=v+st1;
i--;
}
El el1=new El(st1,j);
j=el1.j;
E e=new E(st2,j);
j=e.j;
a=el1.a;
int m=el1.ndim+1;
ndim=m;
p="t"+j;
j++;
ex=p+"="+el1.p+"*limit("+el1.a+","+m+")"+"\n";
ex+=p+"="+p+"+"+e.p;
}
else
{
a=st.charAt(0)+"";
StringBuilder sb=new StringBuilder(st);
sb.deleteCharAt(1);
sb.deleteCharAt(0);
st=sb.toString();
E e=new E(st,j);
j=e.j;
p=e.p;
ndim=1;
}
System.out.println("El-E"+" "+ex+" "+p+" "+a+" "+ndim);
}
}