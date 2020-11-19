package uk.ac.rhul.cs2800;

/**
 * String stack abstraction for the stack class.
 * 
 * @author Philip
 */
public class StrStack {
  
  Stack strstack = new Stack();

  /**
   * Pushes string value onto the stack.
   * 
   * @param str string stored in entry object
   */
  public void push(String str) {
    this.strstack.push(new Entry(str));
  }

}
