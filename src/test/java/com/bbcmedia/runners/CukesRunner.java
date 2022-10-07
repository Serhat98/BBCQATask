package com.bbcmedia.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/resources/features",
        glue = "com/bbcmedia/stepDefinitions",
        dryRun = false,
        tags = "@media"
)
public class CukesRunner {
}
