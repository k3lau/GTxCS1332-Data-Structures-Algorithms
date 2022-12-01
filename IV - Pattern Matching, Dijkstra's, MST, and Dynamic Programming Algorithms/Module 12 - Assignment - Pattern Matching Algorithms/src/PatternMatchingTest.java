import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class PatternMatchingTest {
  @Test
  public void testBoyerMoore() {
    CharSequence pattern = "aaaaab";
    CharSequence text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    CharacterComparator comparator = new CharacterComparator();
    List<Integer> result = PatternMatching.boyerMoore(pattern, text, comparator);
    List<Integer> expected = new ArrayList<>();
    expected.add(35);
    assertEquals(41, comparator.getComparisonCount());
    assertEquals(expected, result);
  }

  @Test
  public void testBoyerMooreQuick() {
    CharSequence pattern = "aaaaab";
    CharSequence text = "aaaab";
    CharacterComparator comparator = new CharacterComparator();
    List<Integer> result = PatternMatching.boyerMoore(pattern, text, comparator);
    List<Integer> expected = new ArrayList<>();
    assertEquals(0, comparator.getComparisonCount());
    assertEquals(expected, result);
  }

  @Test
  public void testBoyerMooreWorst() {
    CharSequence pattern = "baaaaa";
    CharSequence text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    CharacterComparator comparator = new CharacterComparator();
    List<Integer> result = PatternMatching.boyerMoore(pattern, text, comparator);
    List<Integer> expected = new ArrayList<>();
    assertEquals(211, comparator.getComparisonCount());
    assertEquals(expected, result);
  }

  @Test
  public void testBoyerMooreSublinear() {
    CharSequence pattern = "cccccc";
    CharSequence text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    CharacterComparator comparator = new CharacterComparator();
    List<Integer> result = PatternMatching.boyerMoore(pattern, text, comparator);
    List<Integer> expected = new ArrayList<>();
    assertEquals(6, comparator.getComparisonCount());
    assertEquals(expected, result);
  }

  @Test
  public void testBuildLastTable() {
    CharSequence pattern = "happy";
    Map<Character, Integer> table = new HashMap<>();
    table = PatternMatching.buildLastTable(pattern);
    Map<Character, Integer> expected = new HashMap<>();
    Character[] s = { 'h', 'a', 'p', 'y' };
    expected.put(s[0], 0);
    expected.put(s[1], 1);
    expected.put(s[2], 3);
    expected.put(s[3], 4);
    assertEquals(expected, table);
  }

  @Test
  public void testBuildLastTable2() {
    CharSequence pattern = "aaaaab";
    Map<Character, Integer> table = new HashMap<>();
    table = PatternMatching.buildLastTable(pattern);
    Map<Character, Integer> expected = new HashMap<>();
    Character[] s = { 'a', 'b' };
    expected.put(s[0], 4);
    expected.put(s[1], 5);
    assertEquals(expected, table);
  }
}
