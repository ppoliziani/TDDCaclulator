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
  void test() {
    assertEquals(standCalc.evaluate(""), 20,
        "Test to see if evaluate method works and returns a float");
  }

}
