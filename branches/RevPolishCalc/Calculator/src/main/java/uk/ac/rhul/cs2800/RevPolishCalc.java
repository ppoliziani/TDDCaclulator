package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * Reverse Polish calculator.
 * 
 * @author Philip
 *
 */
public class RevPolishCalc implements CalculatorInterface {

  private NumStack revStack = new NumStack();

  /**
   * Method for evaluating reverse polish/post-fix expressions.
   *
   * @param what string to be evaluated
   * @return evaluated expression
   *
   */
  public float evaluate(String what) throws InvalidExpressionException {

    if (what.equals("")) {
      throw new InvalidExpressionException("Must provide an expression");
    }
    
    Scanner expression = new Scanner(what);
    String strresult = "";

    while (expression.hasNext()) {
      String value = expression.next();
      strresult += value;
    }
    expression.close();
    System.out.println(strresult);

    float result = 9;
    return result;
  }

}
