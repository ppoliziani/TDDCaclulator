package uk.ac.rhul.cs2800;

/**
 * Operation Stack facade for the stack class.
 * 
 * @author Philip
 *
 */
public class OpStack {
  
  Stack numstack = new Stack();

  /**
   * Pushes entry object with symbol onto the stack.
   * 
   * @param i symbol pushed onto the stack
   */
  public void push(Symbol i) {
    this.numstack.push(new Entry(i));
  }
  

}
