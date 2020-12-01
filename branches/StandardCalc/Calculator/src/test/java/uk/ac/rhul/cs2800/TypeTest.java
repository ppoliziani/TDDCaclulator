package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TypeTest {

  @Test
  // To pass this test I needed to create each enumerated type and give it a string value.
  // I then created a private variable called "str" and a constructor to assign "str" its
  // value. Then I returned "str" in the toString() method
  void testString() {
    assertEquals(Type.STRING.toString(), "String");
    assertEquals(Type.NUMBER.toString(), "Number");
    assertEquals(Type.SYMBOL.toString(), "Symbol");
    assertEquals(Type.INVALID.toString(), "Invalid");
  }

}
