package uk.ac.rhul.cs2800;

import java.text.DecimalFormat;
import java.util.EmptyStackException;
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
  public float evaluate(String what) throws InvalidExpressionException, BadTypeException {

    if (what.equals("")) {
      throw new InvalidExpressionException("Must provide an expression");
    }

    Scanner expression = new Scanner(what);

    try {
      while (expression.hasNext()) {
        if (expression.hasNextFloat()) {
          revStack.push(expression.nextFloat());
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

        switch (s) {
          case PLUS:
            revStack.push(revStack.pop() + revStack.pop());
            break;
          case MINUS:
            float secondArgumentM = revStack.pop();
            revStack.push(revStack.pop() - secondArgumentM);
            break;
          case TIMES:
            revStack.push(revStack.pop() * revStack.pop());
            break;
          case DIVIDE:
            float secondArgumentD = revStack.pop();
            revStack.push(revStack.pop() / secondArgumentD);
            break;
          default:
            break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    expression.close();

    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(5);

    float result = revStack.pop();
    String res = df.format(result);
    // System.out.println("RES: " + res);

    return result;
  }

}
