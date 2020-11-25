package uk.ac.rhul.cs2800;

/**
 * Custom exception thrown when an invalid expression is passed.
 * 
 * @author Philip
 *
 */
public class InvalidExpressionException extends Exception {

  // eclipse generated UID
  private static final long serialVersionUID = -9001860817336438137L;

  /**
   * Default constructor.
   * 
   * @param message the error message given to the user
   */
  public InvalidExpressionException(String message) {
    super(message);
  }

}
