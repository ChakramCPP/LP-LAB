import java.io.*;
import java.util.*;
import java.util.Stack;

public class ThreeAddressCode 
{
	static int address=10;
    static int index=1;
	 public static void main(String[] args) 
	 {
	        String inputString="(5 * 6 + (4 + 2 % (2 * 8)))";
	        inputString=inputString.replaceAll(" ","");
	        System.out.println("This is input "+inputString);
	        Shunting parentNode=shunt(inputString);
	        System.out.println("Starting post order");
	        postOrder(parentNode);
	        System.out.println("starting dfs");
	        dfs(parentNode);
	    }


	    public static void dfs(Shunting root){
	        if (isOperator(root.charac)){
	            dfs(root.operand1);
	            dfs(root.operand2);
//	            System.out.println(++memory  +" : "+ root.charac +" " + root.operand1.charac +" " + root.operand2.charac);
	            System.out.println(++address  +" : "+ root.name +" = " + root.operand1.name + " "+ root.charac  + " " + root.operand2.name);
	        }
	    }


	    public static void postOrder(Shunting root){
	        if (root.operand1!=null){
	            postOrder(root.operand1);
	        }

	        if (root.operand2!=null){
	            postOrder(root.operand2);
	        }
	        System.out.println(root.charac +" ");
	    }



	    private static Shunting shunt(String inputString) {


	        Stack1 myStack=new Stack1();
	        Operator opr=new Operator();

//	        String inputString="5*3+(4+2*2)";

	        Stack<Character> operatorStack= new Stack();
	        Stack<Shunting> expressionStack=new Stack();

	        Character c;
	        for (int i=0;i<inputString.length();i++){

	            c=inputString.charAt(i);

	            if (c=='('){
	                operatorStack.push(c);
	            }

	            else if (Character.isDigit(c)){
	                expressionStack.push(new Shunting(c));
	            }

	            else if (isOperator(c)){

	                    while (opr.getOperatorPrecedence(myStack.getTopOfOperator(operatorStack)) >= opr.getOperatorPrecedence(c)) {
	                        Character operator = operatorStack.pop();
	                        Shunting e2 = expressionStack.pop();
	                        Shunting e1 = expressionStack.pop();

	                        expressionStack.push(new Shunting(operator,e1,e2,"E"+index++));
	                    }

	                operatorStack.push(c);
	            }

	            else if (c==')'){

	                    while (myStack.getTopOfOperator(operatorStack) != '(') {

	                        Character operator = operatorStack.pop();
	                        Shunting e2 = expressionStack.pop();
	                        Shunting e1 = expressionStack.pop();

	                        expressionStack.push(new Shunting(operator,e1,e2,"E"+index++));
	                    }

	                operatorStack.pop();
	            }

	            else{
	                System.out.println("error error");
	            }
	        }

	        while(!operatorStack.empty()){
	            Character operator=operatorStack.pop();
	            Shunting e2=expressionStack.pop();
	            Shunting e1=expressionStack.pop();
	            expressionStack.push(new Shunting(operator,e1,e2,"E"+index++));
	        }


	        return expressionStack.pop();
	    }

	    public static boolean isOperator(Character c){
	        if (c=='+' || c=='-' || c=='/' || c=='*'|| c=='%'){
	            return true;
	        }
	        else{
	            return false;
	        }
	    }
	}

class Operator {

    public int getOperatorPrecedence(Character inOperator){


        if (inOperator=='+' || inOperator=='-'){
            return 1;
        }
        else if (inOperator=='*'){
            return 2;
        }

        else if (inOperator=='/'){
            return 3;
        }

        else if (inOperator=='%'){
            return 4;
        }

        else if (inOperator=='e'){
            return 0;
        }

        else{
            return 0;
        }
    }
}

class Shunting {
    Shunting operand1;
    Shunting operand2;
    Character charac;
    String name;
    Shunting(Character num){
        charac=num;
        this.name=num+"";

    }

    Shunting(Character num,Shunting e1,Shunting e2,String name){
        operand1=e1;
        operand2=e2;
        charac=num;
        this.name=name;
    }


}

class Stack1 
{

    Character getTopOfOperator(Stack<Character> stack){
        if (stack.isEmpty()){
            return 'e';
        }

        Character top=stack.peek();
        return top;
    }

}

