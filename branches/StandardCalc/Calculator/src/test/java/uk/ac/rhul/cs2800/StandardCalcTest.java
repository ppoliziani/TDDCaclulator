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
  void testStart() {
    assertEquals(standCalc.evaluate(""), 20,
        "Test to see if evaluate method works and returns a float");
  }

  @Test
  // 2nd Test
  // To pass this test I created a new scanner on the string passed to the evaluate method using a
  // while loop to check if the input still has a next character and an if statement checking if
  // that character is a float
  void testScanner() {
    assertEquals(standCalc.evaluate("7 2 5 + /"), 20,
        "Expecting to see the scanner print only the numbers");
  }
}
