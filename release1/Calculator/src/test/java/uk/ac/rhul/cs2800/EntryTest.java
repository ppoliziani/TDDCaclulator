package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EntryTest {

  @Test
  // 1st test
  // To make this test work I created an Entry class and a default constructor

  void test() {
    Entry entry = new Entry();
  }

  @Test
  // 2nd test
  // To pass this test I needed to add a string variable, a constructor that
  // takes a string argument and assigns it to the variable "str" of the class
  // and the getString() method that returns the value of the string

  void testString() throws BadTypeException {
    Entry entry = new Entry("Test String");
    assertEquals(entry.getString(), "Test String",
        "Test to see if an entry object is correctly created and will return "
            + "the correct value with the appropriate get() method");
  }

  @Test
  // 3rd test
  // To pass this test I added a float variable, a constructor that
  // takes a float argument and assigns it to the variable "number" of the class
  // and the getValue() method that returns the value of the number

  void testValue() throws BadTypeException {
    Entry entry = new Entry(5);
    assertEquals(entry.getValue(), 5,
        "Test to see if an entry object is correctly created and will return "
            + "the correct value with the appropriate get() method");
  }

  @Test
  // 4th test
  // To pass this test I added a variable with the type symbol, a constructor that
  // takes a symbol argument and assigns it to the variable "symbol" of the class
  // and the getSymbol() method that calls on the Symbol class toString() method
  // to return the operator symbol as a string

  void testSymbol() throws BadTypeException {
    Entry entry = new Entry(Symbol.PLUS);
    assertEquals(entry.getSymbol(), Symbol.PLUS,
        "Test to see if an entry object is correctly created and will return "
            + "the correct value with the appropriate get() method");
  }

  @Test
  // 5th test
  // To pass this test I added a new variable "type" of type Type defined by the enum class
  // and assigned the type of each variable in their respective constructors.
  // I then made a new method getType() that returned their type

  void testType() {
    Entry entry = new Entry("Test String");
    assertEquals(entry.getType(), Type.STRING, "Test to see if the type is correctly returned");
    Entry entry2 = new Entry(10);
    assertEquals(entry2.getType(), Type.NUMBER, "Test to see if the type is correctly returned");
    Entry entry3 = new Entry(Symbol.PLUS);
    assertEquals(entry3.getType(), Type.SYMBOL, "Test to see if the type is correctly returned");
    // Entry entry4 = new Entry();
    // assertEquals(entry.getType(), Type.INVALID);
  }

  @Test
  // 6th test
  // To pass this test I created a BadTypeException class and in each get() method I
  // threw the exception if the type wasn't the appropriate type

  void testExceptions() {
    Entry entry = new Entry(Symbol.PLUS);
    assertThrows(BadTypeException.class, () -> entry.getString(), "Incorrect type");

    Entry entry2 = new Entry("Test String");
    assertThrows(BadTypeException.class, () -> entry2.getValue(), "Incorrect type");

    Entry entry3 = new Entry(10);
    assertThrows(BadTypeException.class, () -> entry3.getSymbol(), "Incorrect type");
  }


  @Test
  // 7th test
  // To pass this test I needed to override the existing equals() method to return true only
  // if the entries are of the same type and contain the exact same value

  void testEqualsTrue() {
    Entry entry1 = new Entry("Test String");
    Entry entry2 = new Entry("Test String");
    assertEquals(entry1.equals(entry2), true, "Test to see if the same type and value are equal");
  }

  @Test
  // 8th test
  // Didn't need to make any additional changes to the equals() method,
  // just checking other test cases

  void testEqualsFalse1() {
    Entry entry1 = new Entry("Test String");
    Entry entry2 = new Entry("Another Test String");
    assertEquals(entry1.equals(entry2), false,
        "Test to see if the same type but different values are not equal");
  }

  @Test
  // 9th test
  // Didn't need to make any additional changes to the equals() method,
  // just checking other test cases

  void testEqualsFalse2() {
    Entry entry1 = new Entry("Test String");
    Entry entry2 = new Entry(10);
    assertEquals(entry1.equals(entry2), false,
        "Test to see if different values and types are not equal");
  }


  @Test
  // 10th test
  // To pass this test I needed to override the hashCode() method

  void testHashcodeString() {
    Entry entry1 = new Entry("Test String");
    Entry entry2 = new Entry("Test String");
    assertEquals(entry1.hashCode(), entry2.hashCode(),
        "Test to see if the same value and type returns the same hashcode");
  }

  @Test
  // 11th test
  // To pass this test I needed to add a check that the type was a number
  // and return a reasonable hashcode value

  void testHashcodeNumber() {
    Entry entry1 = new Entry(22);
    Entry entry2 = new Entry(22);
    assertEquals(entry1.hashCode(), entry2.hashCode(),
        "Test to see if the same value and type returns the same hashcode");
  }
  
}
