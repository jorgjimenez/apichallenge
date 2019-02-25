package features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "C:\\Users\\jjimenez\\IdeaProjects\\apiworkshop\\src\\test\\Resources\\features", glue = "steps")
public class TrelloTestRunner {

}
