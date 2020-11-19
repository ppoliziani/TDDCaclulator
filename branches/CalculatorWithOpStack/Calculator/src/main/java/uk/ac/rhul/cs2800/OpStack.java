package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

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

  /**
   * Pops the last element from the top of the stack.
   * 
   * @return symbol on the top of the stack
   */
  public Symbol pop() throws BadTypeException {
    Symbol op;
    if (this.isEmpty()) {
      throw new EmptyStackException();
    } else {
      Entry e = this.numstack.pop();
      op = e.getSymbol();
      return op;
    }
  }

  /**
   * Checks if the stack is empty or not.
   * 
   * @return if stack is empty
   */
  public boolean isEmpty() {
    return this.numstack.size() == 0;
  }


}
