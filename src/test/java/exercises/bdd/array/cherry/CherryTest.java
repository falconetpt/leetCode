package exercises.bdd.array.cherry;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/cherrybot/cherryrobot.feature"},
        glue = "exercises.bdd.array.cherry",
        plugin = {"pretty", "json:target/reports/json/cherrybot.json"}
)
public class CherryTest {
}