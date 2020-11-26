package uk.ac.rhul.cs2800;

import java.util.ArrayList;
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
   * @throws BadTypeException
   *
   */
  // Works but not using the Symbol types
  public float evaluate(String what) throws InvalidExpressionException, BadTypeException {

    if (what.equals("")) {
      throw new InvalidExpressionException("Must provide an expression");
    }

    Scanner expression = new Scanner(what);

    ArrayList<String> symbols = new ArrayList<String>();

    while (expression.hasNext()) {
      String value = expression.next();
      System.out.println(value);
      if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
        symbols.add(value);
        System.out.println("SYMBOL: " + value);
      } else {
        revStack.push(Float.parseFloat(value));
        System.out.println("FLOAT:  " + Float.parseFloat(value));
      }
    }

    float result;

    for (String symbol : symbols) {
      if (symbol.equals("+")) {
        revStack.push(revStack.pop() + revStack.pop());
      } else if (symbol.equals("-")) {
        revStack.push(revStack.pop() - revStack.pop());
      } else if (symbol.equals("*")) {
        revStack.push(revStack.pop() * revStack.pop());
      } else if (symbol.equals("/")) {
        revStack.push(revStack.pop() / revStack.pop());
      }
    }

    result = revStack.pop();

    expression.close();

    return result;
  }

}
