package com.stepdefinition;

import org.junit.Assert;

import cucumber.api.java.en.Then;

/**
 * 
 * @author LOGAPRIYA
 * @Description Used to Maintain CommonStep Method
 * @CreationDate 26/06/2022
 *
 */

public class CommonStep {
	@Then("User verify the status code is {int}")
	/**
	 * 
	 * @param expValue
	 * @Description Used to verify status code in all steps
	 * @CreationDate 26/06/2022
	 */
	public void userVerifyTheStatusCodeIs(int expValue) {
		Assert.assertEquals("verify Satus Code", expValue, LoginStep.commonVariables.getStatusCode());
		
	}

}
