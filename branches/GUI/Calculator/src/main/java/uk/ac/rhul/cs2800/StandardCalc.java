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

    String processed = "";

    for (int i = 0; i < what.length(); i++) {
      char c = what.charAt(i);
      if (!Character.isDigit(c)) {
        processed += " " + c + " ";
      } else {
        processed += c;
      }
    }

    StringBuilder postfixExpression = new StringBuilder();

    Scanner expression = new Scanner(processed);

    int expectBracket = 0;
    while (expression.hasNext()) {

      if (expression.hasNextFloat()) {
        float num = expression.nextFloat();
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
        expectBracket++;
      } else if (s == Symbol.RIGHT_BRACKET) {
        try {
          if (expectBracket < 1) {
            throw new InvalidExpressionException("Unbalanced Brackets");
          }
          while (!opStack.isEmpty() && opStack.top() != Symbol.LEFT_BRACKET) {
            postfixExpression.append(opStack.pop().toString() + " ");
            expectBracket--;
          }
          opStack.pop();
        } catch (EmptyStackException e) {
          throw new InvalidExpressionException("Unbalanced Brackets");
        }
      } else {
        while (!opStack.isEmpty() && getPrecedence(s) <= getPrecedence(opStack.top())) {
          postfixExpression.append(opStack.pop().toString() + " ");
        }
        opStack.push(s);
      }

    }
    expression.close();

    if (expectBracket > 0) {
      throw new InvalidExpressionException("Unbalanced Brackets");
    }

    while (!opStack.isEmpty()) {
      postfixExpression.append(opStack.pop().toString() + " ");
    }

    float result = rpCalc.evaluate(postfixExpression.toString());
    return result;
  }

}
