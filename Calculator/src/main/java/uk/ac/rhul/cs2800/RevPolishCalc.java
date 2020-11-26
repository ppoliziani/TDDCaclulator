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
    float result = 9;
    return result;
  }

}
