package uk.ac.rhul.cs2800;

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
        System.out.println(num);
        postfixExpression.append(num + " ");
        continue;
      }
      String value = expression.next();
      Symbol s = Symbol.INVALID;
      for (Symbol sym : Symbol.values()) {
        if (sym.toString().equals(value)) {
          s = sym;
          if (opStack.isEmpty()) { // or precedence is greater
            opStack.push(s);
          } else {
            // check precedence until correct place found
          }
          break;
        }
      }

    }
    expression.close();

    System.out.println(postfixExpression);

    float result = rpCalc.evaluate(what);
    System.out.println(result);
    return result;
  }

}
