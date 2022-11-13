import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExternalChainingHashMapTest {
  @Test
  public void testPut() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.put(5, 5);
    ExternalChainingMapEntry<Integer, Integer> expected = new ExternalChainingMapEntry<>(1, 1);
    assertEquals(expected, test.getTable()[1]);
    assertEquals(new ExternalChainingMapEntry<Integer, Integer>(5, 5), test.getTable()[5]);
  }

  @Test
  public void testPutAndOverwrite() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.put(5, 5);
    test.put(5, 6);
    ExternalChainingMapEntry<Integer, Integer> expected = new ExternalChainingMapEntry<>(1, 1);
    assertEquals(expected, test.getTable()[1]);
    assertEquals(new ExternalChainingMapEntry<Integer, Integer>(5, 6), test.getTable()[5]);
  }

  @Test
  public void testPutAndOverwriteToChain() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.put(5, 5);
    test.put(18, 18);
    ExternalChainingMapEntry<Integer, Integer> expected = new ExternalChainingMapEntry<>(1, 1);
    assertEquals(expected, test.getTable()[1]);
    assertEquals(new ExternalChainingMapEntry<Integer, Integer>(5, 5), test.getTable()[5].getNext());
    assertEquals(new ExternalChainingMapEntry<Integer, Integer>(18, 18), test.getTable()[5]);
    test.put(5, 6);
    assertEquals(new ExternalChainingMapEntry<Integer, Integer>(5, 6), test.getTable()[5].getNext());
  }

  @Test
  public void testPutAndResize() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.put(2, 2);
    test.put(3, 3);
    test.put(4, 4);
    test.put(5, 5);
    test.put(6, 6);
    test.put(7, 7);
    test.put(8, 8);
    test.put(14, 14);
    assertEquals(new ExternalChainingMapEntry<Integer, Integer>(14, 14), test.getTable()[14]);
  }

  @Test
  public void testPutWithChaining() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.put(2, 2);
    test.put(3, 3);
    test.put(4, 4);
    test.put(14, 14);
    test.put(15, 15);
    ExternalChainingMapEntry<Integer, Integer> expected = new ExternalChainingMapEntry<>(14, 14);
    expected.setNext(new ExternalChainingMapEntry<Integer, Integer>(1, 1));
    assertEquals(expected, test.getTable()[1]);
    assertEquals(expected.getNext(), test.getTable()[1].getNext());
  }

  @Test
  public void testPutAndResizeAndChaining() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.put(2, 2);
    test.put(3, 3);
    test.put(4, 4);
    test.put(14, 14);
    test.put(15, 15);
    test.put(27, 27);
    test.put(28, 28);
    test.put(30, 30);
    ExternalChainingMapEntry<Integer, Integer> expected = new ExternalChainingMapEntry<>(28, 28);
    expected.setNext(new ExternalChainingMapEntry<Integer, Integer>(1, 1));
    assertEquals(expected, test.getTable()[1]);
    assertEquals(expected.getNext(), test.getTable()[1].getNext());
  }

  @Test
  public void testRemove() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.remove(1);
    assertEquals(null, test.getTable()[1]);
  }

  @Test
  public void testRemoveTailInChain() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.put(14, 14);
    test.remove(1);
    assertEquals(new ExternalChainingMapEntry<>(14, 14), test.getTable()[1]);
  }

  @Test
  public void testRemoveFirstInChain() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.put(14, 14);
    Integer removedValue = test.remove(14);
    assertEquals(new ExternalChainingMapEntry<>(1, 1), test.getTable()[1]);
    assertEquals(new Integer(14), removedValue);
  }

  @Test
  public void testRemoveMiddleInChain() {
    ExternalChainingHashMap<Integer, Integer> test = new ExternalChainingHashMap<>();
    test.put(1, 1);
    test.put(14, 14);
    test.put(27, 27);
    test.remove(14);
    assertEquals(new ExternalChainingMapEntry<>(27, 27), test.getTable()[1]);
    assertEquals(new ExternalChainingMapEntry<>(1, 1), test.getTable()[1].getNext());
  }
}
