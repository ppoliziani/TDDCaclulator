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
    assertEquals(nstack.pop(), 10, 
        "Test to see if the last value is popped");
  }

}
