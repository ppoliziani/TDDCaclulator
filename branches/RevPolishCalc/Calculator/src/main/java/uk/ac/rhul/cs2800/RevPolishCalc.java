package uk.ac.rhul.cs2800;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
    System.out.println(what);

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

    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(5);

    /*
     * float result = Float.parseFloat(df.format(revStack.pop())); float test = (float) 0.16; String
     * mid = String.valueOf(result); result = (float) Integer.parseInt(mid);
     */
    float result = revStack.pop();
    String res = df.format(result);
    System.out.println("RES: " + res);
    


    expression.close();

    return result;
  }

}
