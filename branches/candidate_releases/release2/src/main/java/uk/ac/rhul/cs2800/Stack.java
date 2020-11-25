package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Implementation of a stack with Entry objects that will 
 * be used to evaluate postfix and infix expressions.
 * 
 * @author Philip
 *
 */
public class Stack {

  ArrayList<Entry> stackArray = new ArrayList<Entry>();

  /**
   * Get the size of the stack.
   * 
   * @return stack size
   */
  public int size() {
    return stackArray.size();
  }

  /**
   * Gets the top element of the stack.
   * 
   * @return top element
   */
  public Entry top() {
    if (stackArray.size() == 0) {
      throw new EmptyStackException();
    } else {
      return stackArray.get(stackArray.size() - 1);
    }
  }

  /**
   * Adds Entry object to the ArrayList.
   * 
   * @param value Entry object being added
   */
  public void push(Entry value) {
    stackArray.add(value);
  }

  /**
   * Gets the top element and removes it from the ArrayList.
   * 
   * @return top element
   */
  public Entry pop() {
    Entry value;
    if (stackArray.size() == 0) {
      throw new EmptyStackException();
    } else {
      value = stackArray.get(stackArray.size() - 1);
      stackArray.remove(stackArray.size() - 1);
      return value;
    }
  }

}
