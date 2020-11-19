package uk.ac.rhul.cs2800;

/**
 * String stack abstraction for the stack class.
 * 
 * @author Philip
 */
public class StrStack {

  Stack strStack = new Stack();

  /**
   * Pushes string value onto the stack.
   * 
   * @param str string stored in entry object
   */
  public void push(String str) {
    this.strStack.push(new Entry(str));
  }

  /**
   * Pops the last element from the stack.
   * 
   * @return String from top element of the stack
   */
  public String pop() throws BadTypeException {
    String str = "";
    Entry e = this.strStack.pop();
    str = e.getString();
    return str;
  }

}
