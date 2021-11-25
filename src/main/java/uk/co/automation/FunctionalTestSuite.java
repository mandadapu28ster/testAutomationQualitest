package uk.co.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * This class can be used to invoke the functional tests from the IDE.
 * Change the tags below (e.g. nonjs, highend, etc) to modify which
 * types of test you want to run. You must also set the corresponding
 * system property in the IDE's launch configuration for this class.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = ".", tags = { "@all","~@commented"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"})
public class FunctionalTestSuite {

}
