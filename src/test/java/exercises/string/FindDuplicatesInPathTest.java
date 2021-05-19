package exercises.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindDuplicatesInPathTest {
  private FindDuplicatesInPath findDuplicatesInPath;

  @BeforeEach
  private void setup() {
    findDuplicatesInPath = new FindDuplicatesInPath();
  }

  @Test
  void findDuplicate_differentFileContent_shouldReturnEmptyList() {
    final var paths = new String[] {
      "root/a 1.txt(abcd) 2.txt(cde)", "root/c 3.txt(xpto)", "root/c/d 4.txt(efgh)"
    };
    assertEquals( Collections.emptyList(),  findDuplicatesInPath.findDuplicate( paths ));
  }

  @Test
  void findDuplicate_sameFileContent_shouldReturnList() {
    final var paths = new String[] {
      "root/a 1.txt(abcd) 2.txt(efgh)",
      "root/c 3.txt(abcd)",
      "root/c/d 4.txt(efgh)",
      "root 4.txt(efgh)"
    };

    final var expectedResult = List.of(
      List.of("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"),
      List.of("root/a/1.txt", "root/c/3.txt")
    );

    assertEquals( expectedResult,  findDuplicatesInPath.findDuplicate( paths ));
  }

  @Test
  void findDuplicate_sameFileContent_shouldReturnList2() {
    final var paths = new String[] {
      "root/a 1.txt(abcd) 2.txt(efgh)",
      "root/c 3.txt(abcd)",
      "root/c/d 4.txt(efgh)"
    };

    final var expectedResult = List.of(
      List.of("root/a/2.txt","root/c/d/4.txt"),
      List.of("root/a/1.txt","root/c/3.txt")
    );

    assertEquals( expectedResult,  findDuplicatesInPath.findDuplicate( paths ));
  }
}