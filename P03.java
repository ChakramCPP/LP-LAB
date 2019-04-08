//LL(1) PARSER
import java.io.*;
import java.util.*;
import java.math.*;
class P03
{
static String res="Accepted";
static String s="";
static String la="";
public static void E()
{
la=s.charAt(0)+"";
if(res.compareTo("Rejected")==0)
return;
if(la.compareTo("(")==0)
{
T();
E1();
}
else if(la.compareTo("i")==0)
{
T();
E1();
}
else
res="Rejected";
}
public static void E1()
{
la=s.charAt(0)+"";
if(res.compareTo("Rejected")==0)
return;
if(la.compareTo("+")==0)
{
StringBuilder sn=new StringBuilder(s);
s=sn.deleteCharAt(0).toString();
T();
E1();
}
else if(la.compareTo(")")==0 || la.compareTo("$")==0);
else
res="Rejected";
}
public static void T()
{
la=s.charAt(0)+"";
if(res.compareTo("Rejected")==0)
return;
if(la.compareTo("(")==0)
{
F();
T1();
}
else if(la.compareTo("i")==0)
{
F();
T1();
}
else
res="Rejected";
}
public static void T1()
{
la=s.charAt(0)+"";
if(res.compareTo("Rejected")==0)
return;
if(la.compareTo("*")==0)
{
StringBuilder sn=new StringBuilder(s);
s=sn.deleteCharAt(0).toString();
F();
T1();
}
else if(la.compareTo("+")==0 || la.compareTo(")")==0 || la.compareTo("$")==0);
else
res="Rejected";
}
public static void F()
{
la=s.charAt(0)+"";
if(res.compareTo("Rejected")==0)
return;
if(la.compareTo("(")==0)
{
StringBuilder sn=new StringBuilder(s);
s=sn.deleteCharAt(0).toString();
E();
sn=new StringBuilder(s);
s=sn.deleteCharAt(0).toString();
}
else if(la.compareTo("i")==0)
{
StringBuilder sn=new StringBuilder(s);
s=sn.deleteCharAt(0).toString();
}
else
res="Rejected";
}
public static void main(String args[])
{
long b=System.currentTimeMillis();

Scanner sc=new Scanner(System.in);
s=sc.next();
la=s.charAt(0)+"";
E();
System.out.println(res);
long e=System.currentTimeMillis();
System.out.println((e-b)*0.001);
}
}