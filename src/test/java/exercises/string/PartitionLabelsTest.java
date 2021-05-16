package exercises.string;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class PartitionLabelsTest {
  private final PartitionLabels partitionLabels = new PartitionLabels();

  @Test
  public void emptyStringShouldReturnEmptyList() {
    assertEquals(Collections.emptyList(), partitionLabels.partitionLabels(""));
  }

  @Test
  public void singleCharStringShouldReturnOneLength() {
    assertEquals(List.of(1), partitionLabels.partitionLabels("a"));
  }

  @Test
  public void multipleSameCharStringShouldReturnLength() {
    assertEquals(List.of(5), partitionLabels.partitionLabels("aaaaa"));
  }

  @Test
  public void multipleDifferentCharStringShouldReturnLength() {
    assertEquals(List.of(2, 1), partitionLabels.partitionLabels("aab"));
  }

  @Test
  public void multipleDifferentCharStringShouldReturnLength2() {
    assertEquals(List.of(9, 7, 8), partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
  }
}