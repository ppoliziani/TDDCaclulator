package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {

  NumStack nstack;

  @BeforeEach
  public void setup() {
    nstack = new NumStack();
  }

  @Test
  // 1st Test
  // To pass this test I needed to create a NumStack class that had an
  // attribute stack of type Stack, along with the push method that
  // creates an entry object with the value specified and uses the stack
  // push method to push it onto the stack
  void testPush() {
    nstack.push(1);
  }

  @Test
  // 2nd Test
  // To pass this test I added the pop method to the NumStack class.
  void testPop() throws BadTypeException {
    nstack.push(1);
    assertEquals(nstack.pop(), 1, "Testing to see if the correct value is returned");
  }

  @Test
  // 3rd Test
  // Did not need to make any changes to the method to pass this test
  void testMultiplePushesAndAPop() throws BadTypeException {
    for (int x = 0; x <= 10; x++) {
      nstack.push(x);
    }
    assertEquals(nstack.pop(), 10, "Test to see if the last value is popped");
  }

  @Test
  // 4th Test
  // To pass this test I added the isEmpty method and made a check to see if the stack size is 0
  void testisEmpty() {
    assertEquals(nstack.isEmpty(), true, "Test to see if the stack is empty");
  }

  @Test
  // 5th Test
  // To pass this test in the pop method I added a check that checks if the stack is empty
  // and throws the EmptyStackException, otherwise it returns the value
  void testException() {
    assertThrows(EmptyStackException.class, () -> nstack.pop(),
        "Test to see if the appropriate exception is thrown");
  }


}
