package exercises.string;

public class MaximumRepeatingSubstring {
  public int maxRepeating(String sequence, String word) {
    StringBuilder str = new StringBuilder(word);
    int count = 0;
    boolean on = true;
    while (on==true)
    {
      if(sequence.contains(str.toString()))
      {
        count++;
        str.append(word);
      }
      else{
        on = false;
      }
    }
    return count;
  }
}
