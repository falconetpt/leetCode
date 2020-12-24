package exercises.bdd.array.decodeString;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/decodeString/square.feature"},
        glue = "exercises.bdd.array.decodeString",
        plugin = {"pretty", "json:target/reports/json/cherrybot.json"}
)
public class DecodeTest {
}