package exercises.bdd.array.cherry;

import exercises.array.CherryPick;
import exercises.utils.ReadFile;
import io.cucumber.java8.En;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class CherryStep implements En {
    private List<String> values;
    private int result;

    public CherryStep() {
        Given("a file {string}", (String file) -> values = ReadFile.readFile(file).collect(Collectors.toList()));

        When("i collect cherry", () -> {
            int[][] array = values.stream()
                    .map( x ->
                            Arrays.stream(x.split(","))
                                    .map(Integer::parseInt)
                                    .mapToInt(i -> i)
                            .toArray()
                    )
                    .toArray(int[][]::new);

            result = new CherryPick().cherryPickup(array);
        });

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
