package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".\\Features"},
//        features = {".\\Features\\login.feature"},
//        features = {".\\Features\\addItemsToCart.feature"},
//        features = {".\\Features\\checkout.feature"},
//        features = {"@target/rerun.txt"},

        glue ={"stepsDefinitions", "hooks"},
        plugin = {
                "pretty", "html:reports/myreports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
        },
        //dryRun = true,
        monochrome = true,
        publish = true
//        tags ="@sanity or @master"
//        tags="@sanity and @master"
//        tags="@sanity and not @master"
//        tags="@master and not @sanity"
//        tags="@sanity"
//        tags="@master"
)

public class TestRun {
}
