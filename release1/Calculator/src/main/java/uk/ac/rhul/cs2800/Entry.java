package uk.ac.rhul.cs2800;


/**
 * Objects created to store numeric values, symbols or strings.
 * 
 * @author Philip
 *
 */
public class Entry {

  // possible values of Entry objects
  private String str;
  private float number;
  private Symbol symbol;
  private Type type;

  /**
   * Default constructor.
   */
  public Entry() {}

  /**
   * String constructor.
   * 
   * @param s the string of an entry object
   */
  public Entry(String s) {
    str = s;
    type = Type.STRING;
  }

  /**
   * Float constructor.
   * 
   * @param value the number of an entry object
   */
  public Entry(float value) {
    number = value;
    type = Type.NUMBER;
  }

  /**
   * Symbol constructor.
   * 
   * @param which the symbol of an entry object
   */
  public Entry(Symbol which) {
    symbol = which;
    type = Type.SYMBOL;
  }

  /**
   * Gets the string of an object.
   * 
   * @return string stored in entry object
   * @throws BadTypeException when getString() method is used for the wrong type
   */
  public String getString() throws BadTypeException {
    if (this.type != Type.STRING) {
      throw new BadTypeException("Incorrect type");
    }
    return str;
  }

  /**
   * Gets the float of an object.
   * 
   * @return number stored in entry object
   * @throws BadTypeException when getValue() method is used for the wrong type
   */
  public float getValue() throws BadTypeException {
    if (this.type != Type.NUMBER) {
      throw new BadTypeException("Incorrect type");
    }
    return number;
  }

  /**
   * Gets the symbol of an object.
   * 
   * @return string associated with the symbol
   * @throws BadTypeException when getSymbol() method is used for the wrong type
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.type != Type.SYMBOL) {
      throw new BadTypeException("Incorrect type");
    }
    return symbol;
  }

  /**
   * Gets the type of an object.
   * 
   * @return the type of entry object
   */
  public Type getType() {
    return type;
  }

  /**
   * Overriding the default equals method to make two objects equal only if 
   * they are of the same type and contain the same string.
   * 
   * @return true or false, if two objects are equal or not
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Entry)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    Entry other = (Entry) obj;
    // only objects with the same type and string are equal
    return this.type == other.type && this.str.equals(other.str);
  }

  /**
   * Calculates the hashcode of an object.
   * 
   * @return the hashcode value
   */
  @Override
  public int hashCode() {
    int result = 0;
    
    // calculating hashcode of a string following this website
    // https://howtodoinjava.com/java/string/string-hashcode-method/
    
    if (this.type == Type.STRING) {
      int len = this.str.length();
      int n = len;
      for (int x = 0; x < len; x++) {
        // creates a number with each letter making the hashcode more unique
        result += str.charAt(x) * 31 * (n); 
        n--;
      }
    } else if (this.type == Type.NUMBER) {
      result = (int) (31 * number);
    }
    return result;
  }

}
