package com.RunnerClasses;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyCucumberProject/MyCucumberProject/F05BigbasketLinks.feature", 
					glue = "com.StepDef",
					tags = "@AmazonLinks",
					publish = true)

public class R05BigbasketLink 
{
	/*
	 * 1. Execute Single Scenario - 	tags = "@SellLink"
	 * 2. Execute Multiple Scenarios -	tags = "@SellLink or @MXPlayerLink"
	 * 3. Skip Single Scenario - 		tags = "not @AmazonPayLink"
	 * 4. Skip Multiple Scenarios - 	tags = "not @AmazonPayLink and not @MXPlayerLink"
	 * 5. Execute All Scenarios -		tags = "@AmazonLinks"
	 */
}
