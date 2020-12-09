package uk.ac.rhul.cs2800;

/**
 * Interface for both calculators.
 * 
 * @author Philip
 *
 */
public interface CalculatorInterface {

  /**
   * Evaluates the expression.
   * 
   * @param what string to be evaluated
   * @return evaluated string
   */
  float evaluate(String what) throws InvalidExpressionException, BadTypeException;

}
