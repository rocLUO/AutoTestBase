package com.appium.TestBase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class demo3 {
		   @BeforeClass
		   public static void setup(){

		   }

		   @AfterClass
		   public static void teardown(){

		  }

		   @Test
		   public void login(){

		  }

		   @Test(dependsOnMethods = { "login" })
		   public void testcase(){

		  }
}
