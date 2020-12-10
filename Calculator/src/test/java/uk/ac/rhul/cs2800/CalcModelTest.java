package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcModelTest {

  CalcModel cm;

  @BeforeEach
  public void setup() {
    cm = new CalcModel();
  }

  @Test
  // 1st Test
  // To pass this test I created a CalcModel class and added an evaluate method that faked the
  // result and returned 7.
  void test() throws InvalidExpressionException, BadTypeException {
    assertEquals(cm.evaluate("2 3 * 1 +"), 7, "Test to see if the expression is evaluated");
  }

  @Test
  // 2nd Test
  //
  void testSwitch() throws InvalidExpressionException, BadTypeException {
    assertEquals(cm.evaluate("2 3 * 1 +"), 7, "Test to see if the expression is evaluated");
    cm.setInfix(true);
    assertEquals(cm.evaluate("1 + 2 * 3"), 7,
        "Test to see if the calculator is switched and correct value returned");
  }

}
