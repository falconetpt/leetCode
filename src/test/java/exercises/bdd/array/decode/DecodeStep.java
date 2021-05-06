package exercises.bdd.array.decode;

import exercises.array.SquareElement;
import exercises.string.Decode;
import io.cucumber.java8.En;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class DecodeStep implements En {
    private String input;
    private int result;

    public DecodeStep() {
        Given("a input {string}", (String input) -> this.input = input);
//        When("i decode it", () -> result = new Decode().numDecodings(input));
        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
