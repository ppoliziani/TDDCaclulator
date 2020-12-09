package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * Ascii view for the cs2800 calculator.
 * 
 * @author Philip
 *
 */
public class AsciiView implements ViewInterface {

  private String expression;
  Observer calculator = null;
  Observer reverse = null;
  Observer infix = null;

  /**
   * Gets the expression from the command line.
   */
  @Override
  public String getExpression() {
    return expression;
  }

  @Override
  public void setAnswer(float ans) {
    System.out.println(ans);
  }

  @Override
  public void addCalcObserver(Observer f) {
    calculator = f;
  }

  @Override
  public void addReverseObserver(Observer f) {
    reverse = f;
  }

  @Override
  public void addInfixObserver(Observer f) {
    infix = f;
  }

  @Override
  public void menu() {
    Scanner scanner = new Scanner(System.in);
    boolean done = false;
    System.out.println("-- Controls --\n - R to set type to reverse polish\n "
        + "- I to set type to infix\n - !Expression to set the expression\n - C to calculate\n "
        + "- Q to quit\n -- Controls --\n\n"
        + "Enter an expression: ");

    while (scanner.hasNext() && !done) {
      String letter = scanner.next();
      switch (letter.toUpperCase().charAt(0)) {
        case 'C':
          if (calculator != null) {
            calculator.notifyObservers();
          }
          break;
        case 'R':
          if (reverse != null) {
            System.out.println("Current Type: Reverse Polish");
            reverse.notifyObservers();
          }
          break;
        case 'I':
          if (infix != null) {
            System.out.println("Current Type: Infix");
            infix.notifyObservers();
          }
          break;
        case '!':
          expression = letter.substring(1, letter.length());
          System.out.println("Experssion to be evaluated: " + expression);
          // done = true;
          break;
        case 'Q':
          System.out.println("Ending session");
          done = true;
          break;
        default:
          break;
      }
    }
    scanner.close();
    
  }

}
