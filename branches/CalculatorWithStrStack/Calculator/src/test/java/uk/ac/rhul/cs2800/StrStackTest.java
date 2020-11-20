package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {

  StrStack sstack;

  @BeforeEach
  public void setup() {
    sstack = new StrStack();
  }

  @Test
  // 1st Test
  // To pass this test I needed to create a StrStack class that had an
  // attribute stack of type Stack, along with the push method that
  // creates an entry object with the String specified and uses the stack
  // push method to push it onto the stack
  void testPush() {
    sstack.push("Test String");
  }

  @Test
  // 2nd Test
  // To pass this test I created a pop method that creates an entry object
  // and gets and returns the value stored in it
  void testPop() throws BadTypeException {
    sstack.push("Test String");
    assertEquals(sstack.pop(), "Test String", "Test to see if pop returns the correct string");
  }

  @Test
  // 3rd Test
  // To pass this test I added an isEmpty method that checks if the size of the stack is 0
  void testisEmpty() {
    assertEquals(sstack.isEmpty(), true,
        "Test to see if an empty stack returns the correct boolean value");
  }

  @Test
  // 4th Test
  // To pass this test I added a check in the pop method that first checks if the stack
  // is empty using the isEmpty method and throws an EmptyStackException if it is or
  // returns the appropriate string if not
  void testException() {
    assertThrows(EmptyStackException.class, () -> sstack.pop(),
        "Test to see if a pop on an empty stack throws the correct exception");
  }
}
