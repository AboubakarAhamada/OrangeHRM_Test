package modules;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(value = Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"json", "json:target/json/results.json"},
        glue = {"modules", "step_definitions"}
)
public class TestRunner {
}
