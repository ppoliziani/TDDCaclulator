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
  // To pass this test I created the StandardCalc class that implements the
  // calculator interface and implements its evaluate method
  void testStart() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("10 10 +"), 20,
        "Test to see if evaluate method works and returns a float");
  }

  @Test
  // 2nd Test
  // To pass this test I created a new scanner on the string passed to the
  // evaluate method using a while loop to check if the input still has a next character and an if
  // statement checking if that character is a float
  void testScanner() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("7 + 2 / 5"), 7.400000095367432,
        "Expecting to see the scanner print only the numbers");
  }

  @Test
  // 3rd test
  // To pass this test I made a call to the RevPolishCalc variable evaluate
  // method and passed the expression and returned the result in the StandardCalc class
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
  // To pass this test I needed to append the float to a string builder each time one was read and
  // push the operator onto the opStack when it was read. Once the expression had finished reading I
  // then pop the plus from the stack and append it to the string builder until the stack is empty
  // and pass the string builder to string to the evaluate method for the RevPolishCalc class.
  void testSYplus() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("7 + 2"), 9,
        "Test to see if the expression if converted to post fix and evaluated correctly");
  }

  @Test
  // 6th Test
  // To pass this test I didn't need to do anything as it is not operator specific
  void testSYothers() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("7 - 2"), 5,
        "Test to see if the expression if converted to post fix and evaluated correctly");
    assertEquals(standCalc.evaluate("7 / 2"), 3.5,
        "Test to see if the expression if converted to post fix and evaluated correctly");
    assertEquals(standCalc.evaluate("7 * 2"), 14,
        "Test to see if the expression if converted to post fix and evaluated correctly");
  }

  @Test
  // 7th Test
  // To pass this test I added a check that happens each time an operator is read. If the stack is
  // not empty, pop the operator from the stack and append it to the string builder to form more of
  // the expression.
  void testMoreThanOneOperator() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("1 - 2 + 3"), 2,
        "Test to see if the expression if converted to post fix and evaluated correctly");
    assertEquals(standCalc.evaluate("1 - 2 + 3 + 4 - 2 + 8 - 1"), 11,
        "Test to see if the expression if converted to post fix and evaluated correctly");
  }

  @Test
  // 8th Test
  // To pass this test I added a top() function to the OpStack class as I needed to check the value
  // of the stack before popping it off. I then checked if the symbol was a left bracket and pushed
  // that onto the stack. Then I checked if the symbol was a right bracket, as long as the stack
  // isn't empty and a left bracket isn't read (indicating the closure of the brackets) the symbol
  // is pushed onto the stack. Lastly to check when an operator is read where to put it, I added a
  // getPrecedence() function to return the precedence of both the operator read and the one on the
  // top of the stack. If the operator on the stack if of higher precedence, it pops it off and
  // appends it to the string. It does this until one of lower precedence is read from the stack and
  // pushes the read operator to the stack.
  //
  void testPrecedence() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("1 + 2 * 3"), 7,
        "Test to see if the expression if converted to post fix and evaluated correctly");
    assertEquals(standCalc.evaluate("1 * 2 + 3"), 5,
        "Test to see if the expression if converted to post fix and evaluated correctly");
  }

  @Test
  // 9th Test
  // To pass this test I added a loop to add spaces to the expression so that it wouldn't evaluate
  // an invalid value such as "(10". I then handled unbalanced brackets by adding an integer
  // variable called expectBrackets that increments each time a left bracket is read and decrements
  // each time a right bracket it read. If this value isn't 0 then there's unbalanced brackets
  // so the InvalidExpressionException is thrown.
  void testBrackets() throws InvalidExpressionException, BadTypeException {
    assertEquals(standCalc.evaluate("( ( 10 / 5 ) + 2 ) * 4"), 16,
        "Test to see if brackets are correctly handled");
    assertEquals(standCalc.evaluate("((10 / 5) + 2) * 4"), 16,
        "Test to see if brackets are correctly handled");
    assertEquals(standCalc.evaluate("((10/5)+2)*4"), 16,
        "Test to see if brackets are correctly handled");
    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate("1 + 2) * 3"),
        "Test to see if an unbalanced expression throws an error");
    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate("1 + 2 - (4 / 3"),
        "Test to see if an unbalanced expression throws an error");
    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate("1 + 2 - ((4 / 3) * 1"),
        "Test to see if an unbalanced expression throws an error");
    assertThrows(InvalidExpressionException.class, () -> standCalc.evaluate("1 + 2 - (4 / 3) * 1)"),
        "Test to see if an unbalanced expression throws an error");
  }

}
