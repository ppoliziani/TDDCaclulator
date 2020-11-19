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
  // To pass this test I added a pop method that creates an entry object 
  // and gets and returns that value stored in that object
  void testPop() throws BadTypeException {
    opstack.push(Symbol.DIVIDE);
    assertEquals(opstack.pop(), Symbol.DIVIDE, "Test to see if the correct symbol is returned");
  }
  
  @Test
  // 3rd Test
  // To pass this test I created an isEmpty method that 
  // checks the size of the stack returning true or false
  void testisEmpty() {
    assertEquals(opstack.isEmpty(), true, "Test to see if empty stack returns true");
    
    opstack.push(Symbol.PLUS);
    opstack.push(Symbol.DIVIDE);
    assertEquals(opstack.isEmpty(), false, "Test to see if a non-empty stack returns false");
  }

}
