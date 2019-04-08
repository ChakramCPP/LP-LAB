//LR(1) PARSER
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
class P05
{
static int in;
static String s="";
static String la="";
static String res="Accepted";
static String st="0";
public static void I()
{
if(in==0)
I0();
else if(in==1)
I1();
else if(in==2)
I2();
else if(in==3)
I3();
else if(in==4)
I4();
else if(in==5)
I5();
else
{
res="Rejected";
return;
}
}
public static void I0()
{
System.out.println("I0 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
if(la.equals("a"))
S3();
else if(la.equals("A"))
{
st+="2";
la=s.charAt(0)+"";
I2();
}
else if(la.equals("C"))
{
st+="1";
la=s.charAt(0)+"";
I1();
}
else
res="Rejected";
}
}
public static void I1()
{
System.out.println("I1 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
if(la.equals("$"))
{
res="Accepted";
return;
}
else
res="Rejected";
}
}
public static void I2()
{
System.out.println("I2 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
if(la.equals("a"))
S5();
else if(la.equals("B"))
{
st+="4";
la=s.charAt(0)+"";
I4();
}
else
res="Rejected";
}
}
public static void I3()
{
System.out.println("I3 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
if(la.equals("a"))
R2();
else
res="Rejected";
}
}
public static void I4()
{
System.out.println("I4 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
if(la.equals("$"))
R1();
else
res="Rejected";
}
}
public static void I5()
{
System.out.println("I5 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
if(la.equals("$"))
R3();
else
res="Rejected";
}
}
public static void R1()
{
System.out.println("R1 "+st+" "+s+" "+la);
StringBuilder sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
st+="C";
la="C";
in=Integer.parseInt(st.charAt(st.length()-2)+"");
I();
}
public static void R2()
{
System.out.println("R2 "+st+" "+s+" "+la);
StringBuilder sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
st+="A";
la="A";
in=Integer.parseInt(st.charAt(st.length()-2)+"");
I();
}
public static void R3()
{
System.out.println("R3 "+st+" "+s+" "+la);
StringBuilder sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
st+="B";
la="B";
in=Integer.parseInt(st.charAt(st.length()-2)+"");
I();
}
public static void S3()
{
System.out.println("S3 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
st+=s.charAt(0)+"";
StringBuilder sb=new StringBuilder(s);
sb.deleteCharAt(0);
s=sb.toString();
st+="3";
la=s.charAt(0)+"";
I3();
}
}
public static void S5()
{
System.out.println("S5 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
st+=s.charAt(0)+"";
StringBuilder sb=new StringBuilder(s);
sb.deleteCharAt(0);
s=sb.toString();
st+="5";
la=s.charAt(0)+"";
I5();
}
}
public static void main(String args[])
{
long b=System.currentTimeMillis();
Scanner sc=new Scanner(System.in);
s=sc.next();
la=s.charAt(0)+"";
I0();
System.out.println(res);
long e=System.currentTimeMillis();
System.out.println((e-b)*0.001);
}
}