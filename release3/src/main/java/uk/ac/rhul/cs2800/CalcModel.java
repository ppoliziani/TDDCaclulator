package uk.ac.rhul.cs2800;

/**
 * State design pattern for switching between calculator models.
 * 
 * @author Philip
 *
 */
public class CalcModel {

  static CalculatorInterface revCalc = new RevPolishCalc();
  static CalculatorInterface standCalc = new StandardCalc();
  static CalculatorInterface current = revCalc;

  /**
   * Evaluates the expression.
   * 
   * @param expression expression to be evaluated
   * @return float evaluated expression
   * @throws BadTypeException if the type is incorrect
   * @throws InvalidExpressionException if the expression is is null or empty
   */
  public float evaluate(String expression) throws InvalidExpressionException, BadTypeException {
    return current.evaluate(expression);
    //return 7;
  }

  /**
   * Sets the current calculator to infix or post-fix depending on boolean value.
   * 
   * @param infix if the calculator is infix
   */
  public void setInfix(boolean infix) {
    if (infix) {
      current = standCalc;
    } else {
      current = revCalc;
    }
  }

}
