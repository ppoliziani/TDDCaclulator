package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Standard Calculator that uses the shunting yard algorithm to convert infix to post-fix
 * expressions.
 * 
 * @author Philip
 *
 */
public class StandardCalc implements CalculatorInterface {

  OpStack opStack = new OpStack();
  RevPolishCalc rpCalc = new RevPolishCalc();
  
  /**
   * Gets the precedence of the symbols.
   * 
   * @param sym symbol to check precedence
   * @return value of precedence
   */
  static int getPrecedence(Symbol sym) {
    int precedence = 0;
    if (sym == Symbol.PLUS || sym == Symbol.MINUS) {
      precedence = 1;
    } else if (sym == Symbol.TIMES || sym == Symbol.DIVIDE) {
      precedence = 2;
    }
    return precedence;
  }

  /**
   * Evaluates the expression.
   * 
   * @param what expression to be converted and evaluated
   * @return result of expression
   * @throws BadTypeException if the type is incorrect
   * @throws InvalidExpressionException if the expression is is null or empty
   */
  public float evaluate(String what) throws InvalidExpressionException, BadTypeException {


    StringBuilder postfixExpression = new StringBuilder();

    Scanner expression = new Scanner(what);

    while (expression.hasNext()) {
      
      if (expression.hasNextFloat()) {
        float num = expression.nextFloat();
        System.out.println("VAL: " + num);
        postfixExpression.append(num + " ");
        continue;
      }

      String value = expression.next();
      Symbol s = Symbol.INVALID;
      for (Symbol sym : Symbol.values()) {
        if (sym.toString().equals(value)) {
          s = sym;        
          break;
        }
      }
      
      if (s == Symbol.LEFT_BRACKET) {
        opStack.push(s);
      } else if (s == Symbol.RIGHT_BRACKET) {
        while (!opStack.isEmpty() && opStack.top() != Symbol.LEFT_BRACKET) {
          postfixExpression.append(opStack.pop().toString() + " ");
        }
        opStack.pop();
      } else {
        while (!opStack.isEmpty() && getPrecedence(s) <= getPrecedence(opStack.top())) {
          postfixExpression.append(opStack.pop().toString() + " ");
        }
        opStack.push(s);
      }

      System.out.println("Current expression: " + postfixExpression);
    }
    expression.close();
    
    while (!opStack.isEmpty()) {
      postfixExpression.append(opStack.pop().toString() + " ");
    }

    System.out.println("Final expression:" + postfixExpression);

    float result = rpCalc.evaluate(postfixExpression.toString());
    System.out.println(result);
    return result;
  }

}
