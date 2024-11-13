package meetingRoom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindDifference {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    final var num1Set = Arrays.stream(nums1)
        .boxed()
        .collect(Collectors.toSet());
    final var num2Set = Arrays.stream(nums2)
        .boxed()
        .collect(Collectors.toSet());


    return List.of(
        num1Set.stream().filter(i -> !num2Set.contains(i)).toList(),
        num2Set.stream().filter(i -> !num1Set.contains(i)).toList());

  }
}
