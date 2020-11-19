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


  /**
   * Pops the last value from the stack.
   * 
   * @return float popped from the stack
   */
  public float pop() throws BadTypeException {
    float value = 0;
    Entry e = this.numstack.pop();
    value = e.getValue();
    return value;
  }


  /**
   * Checks to see if the stack is empty or not.
   * 
   * @return if stack is empty
   */
  public boolean isEmpty() {
    return this.numstack.size() == 0;
  }

}
