import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/Resources/SearchPageFeature")
public class SearchPageRunner extends AbstractTestNGCucumberTests {
}
