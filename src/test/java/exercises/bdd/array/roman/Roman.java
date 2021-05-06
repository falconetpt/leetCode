package exercises.bdd.array.roman;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = {"classpath:features/roman/roman.feature"},
  glue = "exercises.bdd.array.roman",
  plugin = {"pretty", "json:target/reports/json/cherrybot.json"}
)
public class Roman {
}

