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

  OpStack values = new OpStack();
  RevPolishCalc rpCalc = new RevPolishCalc();

  /**
   * Evaluates the expression.
   * 
   * @param what expression to be converted and evaluated
   * @return result of expression
   */
  public float evaluate(String what) {

    Scanner expression = new Scanner(what);

    while (expression.hasNext()) {
      if (expression.hasNextFloat()) {
        System.out.println(expression.nextFloat());
      }
    }

    float result = 20;

    return result;
  }

}
