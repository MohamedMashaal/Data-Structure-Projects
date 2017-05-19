package eg.edu.alexu.csd.datastructure.stack.cs60;

import java.util.Scanner;
 
/**
 * @author Mohamed Mashaal
 *
 */
public class UI {

		public static void main(String[] args) {
			Stack stc = new Stack();
			ExpressionEvaluator exp = new ExpressionEvaluator() ;
			Scanner sc = new Scanner(System.in);
			boolean flag = true ;
			int tempInput = 0 ;
			boolean flag3 = true ;
			Object temp ;
			int size = 0 ;
			System.out.println("<<<<--------------->>>>");
			System.out.println("Please choose an action");
			System.out.println("-----------------------");
			System.out.println("1 - Stack Push");
			System.out.println("2 - Stack Pop");
			System.out.println("3 - Stack Peek");
			System.out.println("4 - Stack Get Size");
			System.out.println("5 - Stack Check is Empty");
			System.out.println("6 - Infix to Postfix Notations");
			System.out.println("7 - Evaluating Postfix Experessions");
			System.out.println("8 - Close the Program");
			System.out.println("====================================================================");
			while (flag) {
					System.out.println("\nEnter A Command Number !!");
					tempInput = sc.nextInt();
					sc.nextLine();
				if (tempInput == 1) {
						System.out.println("Insert the Element");
						temp = sc.nextLine();
						stc.push(temp);
							}

				else if (tempInput == 2) {
					System.out.println("Element Poped : "+ stc.pop().toString());
				}

				else if (tempInput == 3) {
					System.out.println("Element Peeked : "+ stc.peek().toString());
				}

				else if (tempInput == 4) {
					System.out.println("Stack Size : "+ stc.size());
				}

				else if (tempInput == 5) {
					System.out.println("Stack Empty Condition : "+ stc.isEmpty());
				}

				else if (tempInput == 6) {
					System.out.println("Enter the infix Expression : ");
					String x = sc.nextLine();
					System.out.println("Postfix Expression  : " + exp.infixToPostfix(x));
				}

				else if (tempInput == 7) {
					System.out.println("Enter the Postfix Expression to Evalute : ");
					String x = sc.nextLine();
					System.out.println("Value = " + exp.evaluate(x));
				}

				else if (tempInput == 8) {
					flag = false;
						}
				else {
						System.out.println("Wrong input .");
						
						}
			}
			sc.close();
			System.out.println("Bye Bye :D");
			System.out.println("<-------->");
}
}
