package exercises.bdd.array.array.cherry;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/square/square.feature"},
        glue = "exercises.bdd.array.array.cherry",
        plugin = {"pretty", "json:target/reports/json/square.json"}
)
public class SquareTest {
}