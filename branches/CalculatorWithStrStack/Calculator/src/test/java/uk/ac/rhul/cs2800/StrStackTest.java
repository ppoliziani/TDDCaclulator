package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}
