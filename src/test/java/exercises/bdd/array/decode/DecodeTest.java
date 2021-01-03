package exercises.bdd.array.decode;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/numDecodings/decoding.feature"},
        glue = "exercises.bdd.array.decode",
        plugin = {"pretty", "json:target/reports/json/square.json"}
)
public class DecodeTest {
}