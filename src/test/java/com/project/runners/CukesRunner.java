package com.project.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",// store failed scenario names in rerun.txt
                "json:target/cucumber.json"//generate json execution report to be used for html report
        },
        features = "src/test/resources/features",
        glue = "com/project/step_definitions",
        dryRun = false,
        tags = "@findtransactions"
)
public class CukesRunner {

}
