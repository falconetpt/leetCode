package exercises.bdd.array.array.cherry;

import exercises.array.CherryPick;
import exercises.array.SquareElement;
import exercises.utils.ReadFile;
import io.cucumber.java8.En;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class SquareStep implements En {
    private int[] values;
    private String result;

    public SquareStep() {
        Given("a input {string}", (String string) -> {
            values = Arrays.stream(string.split(","))
                        .filter(x -> !x.isBlank())
                        .mapToInt(Integer::parseInt)
                        .toArray();
        });

        When("i square every number", () -> {
            result = Arrays.stream(new SquareElement().sortedSquares(values))
                        .boxed()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));
        });


        Then("the result should be {string}", (a) -> assertEquals(a, result) );
    }
}
