package com.kss;



import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/java/com/kss"
}, glue = "step_definitions")
public class RunnerClass {
    public RunnerClass(){

    }
}
