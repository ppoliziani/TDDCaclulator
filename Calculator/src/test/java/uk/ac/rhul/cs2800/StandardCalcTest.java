package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalcTest {

  StandardCalc standCalc;

  @BeforeEach
  public void setup() {
    standCalc = new StandardCalc();
  }

  @Test
  // 1st Test
  // To pass this test I created the StandardCalc class that implements the calculator interface and
  // implements its evaluate method
  void testStart() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("10 10 +"), 20,
        "Test to see if evaluate method works and returns a float");

  }

  @Test
  // 2nd Test
  // To pass this test I created a new scanner on the string passed to the evaluate method using a
  // while loop to check if the input still has a next character and an if statement checking if
  // that character is a float
  void testScanner() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("7 2 5 + /"), 1,
        "Expecting to see the scanner print only the numbers");
  }

  @Test
  // 3rd test
  // To pass this test I made a call to the RevPolishCalc variable evaluate method and passed the
  // expression and returned the result in the StandardCalc class
  void testRev() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("7 2 +"), 9,
        "Test to see if the StandardCalc class correctly uses the "
            + "RevPolishCalc class to evaluate the converted string");
  }

  @Test
  // 4th Test
  // I didn't need to make any amendments to the code to pass this test
  void testException() {
    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate(""),
        "Test to see if the expression is thrown");
  }
  
  @Test
  // 5th Test
  //
  void testShuntingYardAllgorithm() {
    
  }
}
