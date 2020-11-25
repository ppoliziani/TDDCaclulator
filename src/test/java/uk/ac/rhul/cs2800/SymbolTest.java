package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SymbolTest {

  @Test
  // To pass this test I had to create each operator as an Enum type
  // and give it its associated operator string symbol.
  // I also had to add a toString() method to return the string
  void testString() {
    assertEquals(Symbol.PLUS.toString(), "+");
    assertEquals(Symbol.MINUS.toString(), "-");
    assertEquals(Symbol.TIMES.toString(), "*");
    assertEquals(Symbol.DIVIDE.toString(), "/");
    assertEquals(Symbol.LEFT_BRACKET.toString(), "(");
    assertEquals(Symbol.RIGHT_BRACKET.toString(), ")");
    assertEquals(Symbol.INVALID.toString(), "!");
  }

}