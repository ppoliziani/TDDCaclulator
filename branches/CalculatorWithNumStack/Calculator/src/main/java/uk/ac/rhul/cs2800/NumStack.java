package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Number Stack abstraction for the stack class.
 * 
 * @author Philip
 */
public class NumStack {

  Stack numstack = new Stack();

  /**
   * Pushes float value onto the stack.
   * 
   * @param i value stored in entry object
   */
  public void push(float i) {
    Entry entryFloat = new Entry(i);
    this.numstack.push(entryFloat);
  }

}
