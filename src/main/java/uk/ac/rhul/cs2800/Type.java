package uk.ac.rhul.cs2800;

/**
 * Valid input types for the calculator stack.
 * 
 * @author Philip
 *
 */
public enum Type {
  STRING("String"), NUMBER("Number"), SYMBOL("Symbol"), INVALID("Invalid");

  private String str;

  /**
   * Type constructor.
   * 
   * @param s the string associated to a type
   */
  Type(String s) {
    str = s;
  }


  /**
   * Method to return string type.
   * 
   * @return string value of a type
   */
  public String toString() {
    return this.str;
  }
}
