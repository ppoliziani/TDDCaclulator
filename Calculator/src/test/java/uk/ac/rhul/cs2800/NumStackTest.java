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

}
