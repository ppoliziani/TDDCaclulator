package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {

  RevPolishCalc revCalc;

  @BeforeEach
  public void setup() {
    revCalc = new RevPolishCalc();
  }

  @Test
  // 1st Test
  // To pass this test I created a new RevPolishCalc class that implements the CalculatorInterface
  // along with the evaluate method. I faked this test by getting the method to return 9.
  void testFloat() throws InvalidExpressionException {
    assertEquals(revCalc.evaluate("7 2 +"), 9, "Test to see if a float is returned");
  }

}
