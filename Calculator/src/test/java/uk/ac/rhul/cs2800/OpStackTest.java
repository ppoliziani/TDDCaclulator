package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {

  OpStack opstack;
  
  @BeforeEach
  public void setup() {
    opstack = new OpStack();
  }
  
  @Test
  // 1st Test
  // To pass this test I created a push method in the OpStack class 
  // that pushes a new entry object with a symbol onto the stack
  void testPush() {
    opstack.push(Symbol.PLUS);
  }
  
  @Test
  // 2nd Test
  //
  void testPop() throws BadTypeException {
    opstack.push(Symbol.DIVIDE);
    assertEquals(opstack.pop(), Symbol.DIVIDE, "Test to see if the correct symbol is returned");
  }

}
