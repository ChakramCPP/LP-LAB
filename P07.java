//LALR PARSER
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
class P07
{
static int in;
static String s="";
static String st="0";
static String la="";
static String res="Accepted";
public static void I()
{
System.out.println("I() "+in);
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
else if(in==6)
I6();
else if(in==7)
I7();
else if(in==8)
I8();
else if(in==9)
I9();
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
if(la.equals("*"))
S4();
else if(la.equals("i"))
S5();
else if(la.equals("S"))
{
st+="1";
la=s.charAt(0)+"";
I1();
}
else if(la.equals("L"))
{
st+="2";
la=s.charAt(0)+"";
I2();
}
else if(la.equals("R"))
{
st+="3";
la=s.charAt(0)+"";
I3();
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
if(la.equals("="))
S6();
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
if(la.equals("$"))
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
if(la.equals("*"))
S4();
else if(la.equals("i"))
S5();
else if(la.equals("L"))
{
st+="8";
la=s.charAt(0)+"";
I8();
}
else if(la.equals("R"))
{
st+="7";
la=s.charAt(0)+"";
I7();
}
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
if(la.equals("=") || la.equals("$"))
R4();
else
res="Rejected";
}
}
public static void I6()
{
System.out.println("I6 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
if(la.equals("*"))
S4();
else if(la.equals("i"))
S5();
else if(la.equals("L"))
{
st+="8";
la=s.charAt(0)+"";
I8();
}
else if(la.equals("R"))
{
st+="9";
la=s.charAt(0)+"";
I9();
}
else
res="Rejected";
}
}
public static void I7()
{
System.out.println("I7 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
if(la.equals("=") || la.equals("$"))
R3();
else
res="Rejected";
}
}
public static void I8()
{
System.out.println("I8 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
if(la.equals("=")  || la.equals("$"))
R5();
else
res="Rejected";
}
}
public static void I9()
{
System.out.println("I9 "+st+" "+s+" "+la);
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
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
st+="S";
la="S";
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
st+="S";
la="S";
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
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
st+="L";
la="L";
in=Integer.parseInt(st.charAt(st.length()-2)+"");
I();
}
public static void R4()
{
System.out.println("R4 "+st+" "+s+" "+la);
StringBuilder sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
st+="L";
la="L";
in=Integer.parseInt(st.charAt(st.length()-2)+"");
I();
}
public static void R5()
{
System.out.println("R5 "+st+" "+s+" "+la);
StringBuilder sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
sb=new StringBuilder(st);
sb.deleteCharAt(st.length()-1);
st=sb.toString();
st+="R";
la="R";
in=Integer.parseInt(st.charAt(st.length()-2)+"");
I();
}
public static void S4()
{
System.out.println("S4 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
st+=s.charAt(0)+"";
StringBuilder sb=new StringBuilder(s);
sb.deleteCharAt(0);
s=sb.toString();
st+="4";
la=s.charAt(0)+"";
I4();
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
public static void S6()
{
System.out.println("S6 "+st+" "+s+" "+la);
if(res.equals("Rejected"))
return;
else
{
st+=s.charAt(0)+"";
StringBuilder sb=new StringBuilder(s);
sb.deleteCharAt(0);
s=sb.toString();
st+="6";
la=s.charAt(0)+"";
I6();
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
System.out.println((e-b)*0.001);}
}