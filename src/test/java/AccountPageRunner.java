import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/Resources/AccountPageFeature")
public class AccountPageRunner extends AbstractTestNGCucumberTests {
}
