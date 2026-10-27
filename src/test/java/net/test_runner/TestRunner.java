package net.test_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\Feature",
                   glue = {"net.stepdefinition","net.hooks"},
                   monochrome = !true,
                   dryRun = !true, publish = true,
                   plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
                  // tags = "@logout")

public class TestRunner {

}
