package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidSudokuTest {
  private ValidSudoku validSudoku;

  @Before
  public void setUp() throws Exception {
    validSudoku = new ValidSudoku();
  }

  @Test
  public void isValidSudoku() {
    assertFalse(validSudoku.isValidSudoku(
      new char[][]
        {
          {'.','.','.','.','5','.','.','1','.'},
          {'.','4','.','3','.','.','.','.','.'},
          {'.','.','.','.','.','3','.','.','1'},
          {'8','.','.','.','.','.','.','2','.'},
          {'.','.','2','.','7','.','.','.','.'},
          {'.','1','5','.','.','.','.','.','.'},
          {'.','.','.','.','.','2','.','.','.'},
          {'.','2','.','9','.','.','.','.','.'},
          {'.','.','4','.','.','.','.','.','.'}}
    ));
  }
}