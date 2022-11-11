import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.util.Arrays;

public class MinHeapTest {
  @Test
  public void testAdd() {
    MinHeap<Integer> test = new MinHeap<>();
    test.add(1);
    test.add(2);
    test.add(3);
    test.add(4);
    test.add(5);
    test.add(6);
    test.add(7);
    test.add(8);
    test.add(9);
    test.add(10);
    test.add(11);
    test.add(12);
    test.add(13);
    test.add(14);
    test.add(15);
    Integer[] expected = new Integer[26];
    expected[1] = 1;
    expected[2] = 2;
    expected[3] = 3;
    expected[4] = 4;
    expected[5] = 5;
    expected[6] = 6;
    expected[7] = 7;
    expected[8] = 8;
    expected[9] = 9;
    expected[10] = 10;
    expected[11] = 11;
    expected[12] = 12;
    expected[13] = 13;
    expected[14] = 14;
    expected[15] = 15;
    System.out.println(Arrays.toString(test.getBackingArray()));
    assertEquals(Arrays.toString(expected), Arrays.toString(test.getBackingArray()));
  }

  @Test
  public void testAdd2() {
    MinHeap<Integer> test = new MinHeap<>();
    test.add(1);
    test.add(2);
    test.add(3);
    test.add(4);
    test.add(5);
    test.add(6);
    test.add(7);
    test.add(8);
    test.add(9);
    test.add(0);
    Integer[] expected = new Integer[13];
    expected[1] = 0;
    expected[2] = 1;
    expected[3] = 3;
    expected[4] = 4;
    expected[5] = 2;
    expected[6] = 6;
    expected[7] = 7;
    expected[8] = 8;
    expected[9] = 9;
    expected[10] = 5;
    System.out.println(Arrays.toString(test.getBackingArray()));
    assertEquals(Arrays.toString(expected), Arrays.toString(test.getBackingArray()));
  }

  @Test
  public void testRemove() {
    MinHeap<Integer> test = new MinHeap<>();
    test.add(0);
    test.add(1);
    test.add(2);
    test.add(4);
    test.add(3);
    test.add(5);
    test.add(7);
    test.add(6);
    test.add(8);
    test.add(9);
    test.add(10);
    test.remove();
    Integer[] expected = new Integer[13];
    expected[1] = 1;
    expected[2] = 3;
    expected[3] = 2;
    expected[4] = 4;
    expected[5] = 9;
    expected[6] = 5;
    expected[7] = 7;
    expected[8] = 6;
    expected[9] = 8;
    expected[10] = 10;
    expected[11] = null;
    System.out.println(Arrays.toString(test.getBackingArray()));
    assertEquals(Arrays.toString(expected), Arrays.toString(test.getBackingArray()));
  }

  @Test
  public void testRemove2() {
    MinHeap<Integer> test = new MinHeap<>();
    test.add(0);
    test.add(7);
    test.add(14);
    test.add(42);
    test.add(28);
    test.add(35);
    test.add(21);
    test.remove();
    Integer[] expected = new Integer[13];
    expected[1] = 7;
    expected[2] = 21;
    expected[3] = 14;
    expected[4] = 42;
    expected[5] = 28;
    expected[6] = 35;
    System.out.println(Arrays.toString(test.getBackingArray()));
    assertEquals(Arrays.toString(expected), Arrays.toString(test.getBackingArray()));
  }

  @Test
  public void testRemove3() {
    MinHeap<Integer> test = new MinHeap<>();
    test.add(0);
    test.add(14);
    test.add(7);
    test.add(28);
    test.add(21);
    test.add(56);
    test.add(49);
    test.add(42);
    test.add(35);
    test.remove();
    Integer[] expected = new Integer[13];
    expected[1] = 7;
    expected[2] = 14;
    expected[3] = 35;
    expected[4] = 28;
    expected[5] = 21;
    expected[6] = 56;
    expected[7] = 49;
    expected[8] = 42;
    System.out.println(Arrays.toString(test.getBackingArray()));
    assertEquals(Arrays.toString(expected), Arrays.toString(test.getBackingArray()));
  }

  @Test
  public void testRemove4() {
    MinHeap<Integer> test = new MinHeap<>();
    test.add(0);
    test.add(7);
    test.add(14);
    test.add(35);
    test.add(28);
    test.add(42);
    test.add(21);
    test.remove();
    Integer[] expected = new Integer[13];
    expected[1] = 7;
    expected[2] = 21;
    expected[3] = 14;
    expected[4] = 35;
    expected[5] = 28;
    expected[6] = 42;
    System.out.println(Arrays.toString(test.getBackingArray()));
    assertEquals(Arrays.toString(expected), Arrays.toString(test.getBackingArray()));
  }
}
