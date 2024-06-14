import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/Resources/LoginPageFeature")
public class LoginPageRunner extends AbstractTestNGCucumberTests {
}
