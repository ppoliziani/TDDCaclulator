package uk.ac.rhul.cs2800;

/**
 * Symbols used for arithmetic and their associated character.
 * 
 * @author Philip
 *
 */
public enum Symbol {
  PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/"), LEFT_BRACKET("("), RIGHT_BRACKET(")"), INVALID(
      "!");

  private String associatedString;


  /**
   * Symbol constructor.
   * 
   * @param s the operator symbol
   */
  Symbol(String s) {
    associatedString = s;
  }


  /**
   * Gets the string of the enumerated type.
   * 
   * @return string that represents the operator
   */
  public String toString() {
    return this.associatedString;
  }
}
