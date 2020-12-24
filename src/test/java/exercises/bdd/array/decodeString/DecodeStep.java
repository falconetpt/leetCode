package exercises.bdd.array.decodeString;

import exercises.string.DecodeString;
import io.cucumber.java8.En;

import static org.junit.Assert.assertEquals;


public class DecodeStep implements En {
    private String value;
    private String result;

    public DecodeStep() {
        Given("a input {string}", (String string) -> {
            value = string;
        });

        When("i decode it and check index {int}", (Integer index) -> {
            result = new DecodeString().decodeAtIndex(value, index);
        });

        Then("the result should be {string}", (String expected) -> {
            assertEquals(expected, result);
        });
    }
}
