package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

  Stack stack;

  @BeforeEach
  public void setup() {
    stack = new Stack();
  }


  @Test
  // 1st Test
  // To pass this test I added a variable called size and set it to 0, faking the test.
  void testSize() {
    assertEquals(stack.size(), 0, "Test the size of the stack");
  }

  @Test
  // 2nd Test
  // To pass this test I created an ArrayList to hold the values and
  // changed the variable size to return the size of the ArrayList.
  void testPush() {
    // stack.push(5); I had to replace the integer push with one of
    // an entry object as the stack takes entry objects
    Entry entry = new Entry(1);
    stack.push(entry);
    assertEquals(stack.size(), 1,
        "Test to see if pushing a number to the stack increments the size");
  }

  @Test
  // 3rd Test
  // To pass this test I didn't need to change anything, just verifying
  // that multiple values can be pushed onto the stack and the size of
  // the stack increases accordingly
  void testPush2() {
    for (int x = 0; x < 100; x++) {
      // stack.push(5); I had to replace the integer push with one of
      // an entry object as the stack takes entry objects
      Entry entry = new Entry(x);
      stack.push(entry);
    }
    assertEquals(stack.size(), 100,
        "Test to see if pushing a number to the stack increments the size");
  }

  @Test
  // 4th Test
  // To pass this test I added a check in the pop method and made it throw the
  // new Exception if size == 0, indicating the stack is empty
  void testPop() {
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Test if popping an empty list returns an exception");
  }

  @Test
  // 5th Test
  // To pass this test I needed to assign a variable called value the last element
  // of the ArrayList and then remove that element and return value

  // ======== After changing to Entry objects ===========

  // To pass this test I needed to change the ArrayList to take Entry objects,
  // changed the parameter type of the push() method to Entry,
  // and the return type of the pop() method to Entry
  void testPushThenPop() {
    // stack.push(5); I had to replace the integer push with one of
    // an entry object as the stack takes entry objects
    Entry entry1 = new Entry(5);
    stack.push(entry1);
    assertEquals(stack.pop(), entry1,
        "Test to see if popping a number from the stack returns the value");
    assertEquals(stack.size(), 0,
        "Test to see if popping a number from the stack decrements the size");
  }

  @Test
  // 6th test
  // Didn't need to make any changes to the code,
  // just verifying pushing and popping consecutively works
  void testPushAndPopAlot() {
    Entry entry = new Entry(1);
    for (int x = 0; x <= 100; x++) {
      // stack.push(x); I had to replace the integer push with one of
      // an entry object as the stack takes entry objects
      stack.push((entry));
    }

    for (int z = 100; z >= 0; z--) {
      assertEquals(stack.pop(), entry);
    }

    assertEquals(stack.size(), 0, "Test to see if all entry objects were removed");
  }

  @Test
  // 7th test
  // To pass this test I created a top() method that always contained the
  // last element pushed onto the stack

  // ======== After changing to Entry objects ===========

  // To pass this test I had to change the return type of the top() method to Entry
  // and change the "value" variable to type Entry as well
  void testTop() {
    Entry entry = new Entry(1);
    for (int x = 0; x <= 6; x++) {
      // stack.push(x); I had to replace the integer push with one of
      // an entry object as the stack takes entry objects
      stack.push(entry);
    }
    Entry entry2 = new Entry(2);
    stack.push(entry2);
    assertEquals(stack.top(), entry2, "Test to see if it returns the value at the top");
    assertEquals(stack.size(), 8, "Test to see if the value isn't removed");
  }

  @Test
  // 8th test
  // To pass this test I added a check to see if the stack
  // size was 0 and threw an empty stack exception
  void testTopException() {
    assertThrows(EmptyStackException.class, () -> stack.top(),
        "Test if checking top value of an empty stack returns an exception");
  }



  // After testing the stack with numbers and verifying it all worked I began creating the Entry
  // class following the TDD style. I've therefore commented out all the above code as it will
  // no longer work with the new stack class that creates an ArrayList of Entry objects as oppose
  // to Integers. The following tests test the functionality of the stack class with support
  // for Entry objects


  @Test
  // 9th test
  // To pass this test I needed to change the ArrayList to take Entry objects,
  // changed the parameter type of the push() method to Entry,
  // and the return type of the pop() method to Entry

  void testPushAndPopWithEntry() {
    Entry entry = new Entry(1);
    stack.push(entry);
    assertEquals(stack.pop(), entry,
        "Test if popping with an entry object will return the same entry object");
  }


  @Test
  // 10th test
  // To pass this test I had to change the return type of the top() method to Entry
  // and change the "value" variable to type Entry as well

  void testTopWithEntry() {
    Entry entry1 = new Entry(1);
    Entry entry2 = new Entry(2);
    stack.push(entry1);
    stack.push(entry2);
    assertEquals(stack.top(), entry2, "Test if the correct entry object is returned");
  }

}
