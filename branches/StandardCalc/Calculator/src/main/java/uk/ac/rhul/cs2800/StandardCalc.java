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

      // System.out.println(postfixExpression);

      String value = expression.next();
      Symbol s = Symbol.INVALID;
      for (Symbol sym : Symbol.values()) {
        if (sym.toString().equals(value)) {
          s = sym;
          if (!opStack.isEmpty()) {
            postfixExpression.append(opStack.pop().toString() + " ");
          }
          break;
        }
      }
      

      opStack.push(s);

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
