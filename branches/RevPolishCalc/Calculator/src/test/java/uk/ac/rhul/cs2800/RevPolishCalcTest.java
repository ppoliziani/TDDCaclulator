package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
  void testFloat() throws InvalidExpressionException, BadTypeException {
    assertEquals(revCalc.evaluate("7 2 +"), 9, "Test to see if a float is returned");
  }

  @Test
  // 2nd Test
  // To pass this test I added a scanner that reads the
  // input of the string given to it and prints it to the console.
  void testReadingString() throws InvalidExpressionException, BadTypeException {
    // assertEquals(revCalc.evaluate("7 2 +"), "72+");
    assertEquals(revCalc.evaluate("7 2 +"), 9,
        "Test to see if the string/expression passed is being read");
  }

  @Test
  // 3rd Test
  // To pass this test I added a check at the beginning to 
  // check if the string is empty, throw the exception
  void testNoInput() {
    assertThrows(InvalidExpressionException.class, () -> revCalc.evaluate(""),
        "Test to see if the invalidexpression exception is thrown");
  }
  
  @Test
  // 4th Test
  // To pass this test I essentially faked it. I added an ArrayList of strings and checked 
  // if the current character was a symbol and added that to the ArrayList, otherwise I converted 
  // the string into a float and pushed that onto the NumStack. I then iterated over each symbol 
  // in the ArrayList and applied that symbol to the top 2 elements of the stack and pushed their 
  // result back onto the stack. At the end I set the result variable equal to the last element 
  // on the stack and return it.
  void testEvaluate() throws InvalidExpressionException, BadTypeException {
    assertEquals(revCalc.evaluate("7 2 +"), 9, "Test to see if the evaluate method works");
    assertEquals(revCalc.evaluate("5 3 2 * +"), 11, "Test to see if the evaluate method works");
  }

}
