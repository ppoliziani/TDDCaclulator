package uk.ac.rhul.cs2800;

/**
 * Custom exception thrown when methods are used on Entry objects containing the wrong type.
 * 
 * @author Philip
 *
 */
public class BadTypeException extends Exception {
  // eclipse generated UID
  private static final long serialVersionUID = -7851054470129137004L;

  /**
   * Default constructor.
   * 
   * @param message the error message given to the user
   */
  public BadTypeException(String message) {
    super(message);
  }
 
}
