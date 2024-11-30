package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Pairs {
  public int[][] validArrangement(int[][] pairs) {
    final var result = new int[pairs.length][2];
    final var beginingMap = new HashMap<Integer, LinkNode>();
    final var endMap = new HashMap<Integer, LinkNode>();

    final var firstElement = pairs[0];
    final var startNode = new LinkNode(firstElement, null);
    beginingMap.put(firstElement[0], startNode);
    endMap.put(firstElement[1], startNode);

    final var seen = new HashSet<int[]>();
    seen.add(firstElement);

    var currentElement = fillLinkedList(pairs, beginingMap, endMap, seen, startNode);

    while (currentElement.prev != null) currentElement = currentElement.prev;

    for (int i = 0; i < result.length; i++) {
      System.out.println(Arrays.toString(currentElement.pair));
      result[i] = currentElement.pair;
      currentElement = currentElement.next;
    }

    return result;
  }

  private LinkNode fillLinkedList(int[][] pairs, HashMap<Integer, LinkNode> beginingMap,
                                  HashMap<Integer, LinkNode> endMap, Set<int[]> seen, LinkNode startNode) {
    var head = startNode;
    for (int i = 1; i < pairs.length; i++) {
      final var element = pairs[i];
      final var node = new LinkNode(element, null);

      seen.add(element);
      System.out.println(element[0] + ":" + element[1]);
      if (beginingMap.containsKey(element[1])) {
        System.out.println("Left");
        final var next = beginingMap.get(element[1]);
        if (!next.equals(head)) head = node;
        node.next = next;
        next.prev = node;
      } else if (endMap.containsKey(element[0])) {
        System.out.println("right");
        final var prev = endMap.get(element[0]);
        prev.next = node;
        node.prev = prev;

      }

      beginingMap.put(element[0], node);
      endMap.put(element[1], node);
    }

    System.out.println(beginingMap + ":" + endMap);

    return head;
  }


  public class LinkNode{
    int[] pair;
    LinkNode next;
    LinkNode prev;

    public LinkNode(int[] pair, LinkNode next) {
      this.pair = pair;
      this.next = next;
    }

    @Override
    public String toString() {
      return "LinkNode{" +
          "pair=" + Arrays.toString(pair) +
          ", next=" + next +
          ", prev=" + prev +
          '}';
    }
  }
}
