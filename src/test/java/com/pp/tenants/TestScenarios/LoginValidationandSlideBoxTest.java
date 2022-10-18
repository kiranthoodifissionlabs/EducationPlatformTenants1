package com.pp.tenants.TestScenarios;

import com.pp.tenants.PageObjects.HomePage;
import com.pp.tenants.PageObjects.LandingPage;
import com.pp.tenants.Utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginValidationandSlideBoxTest extends BaseClass {
    LandingPage landingPage;
    HomePage homePage;

    @Test(priority = 1)
    @Parameters({"url","username","password"})
    public void Verifyingtheloginfunctionality(String urlValue,String usernameValue, String passwordValue){
        extentTest.log(LogStatus.INFO,"Verifyingtheloginfunctionality");
      landingPage = new LandingPage();
        landingPage.login(urlValue,usernameValue,passwordValue);
    }

    @Test(priority = 2)
    public void Verifyingthevariouslogintitles(){
        extentTest.log(LogStatus.INFO,"Verifyingthevariouslogintitles");
        String title = landingPage.validateLoginPageTitle();
        extentTest.log(LogStatus.INFO,"Executing the tests for tenant " + title);
        if(webDriver.getTitle().equals(titleValidation(title)))
        {
            extentTest.log(LogStatus.PASS, "Navigated to the specified URL");
        }
        else
        {
           try {
                extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(CaptureScreen(webDriver))+"Login test failed");
               //extentTest.log(LogStatus.ERROR,extentTest.getDescription());
              // extentTest.log(LogStatus.ERROR, "StackTrace Result: " + Thread.currentThread().getStackTrace());
           } catch (IOException e) {
               extentTest.log(LogStatus.ERROR, ExceptionUtils.getStackTrace(e) );
            }
        }
    }



   @Test(priority = 3)
    public void VerifyingtheHomeoptionsandcreatingSlideBoxFolder() throws InterruptedException {
        extentTest.log(LogStatus.INFO,"VerifyingtheHomeoptionsandcreatingSlideBoxFolder");
        homePage =new HomePage();
        homePage.SelectDashboard();
        homePage.SelectSlideBox();
        homePage.createFolder();
        homePage.isUploadButtonisDisplayed();
        homePage.isRadiologyButtonisDisplayed();
    }

    @Test(priority = 4)
    public void VerifytheLogoutFunctionality(){
        extentTest.log(LogStatus.INFO,"VerifytheLogoutFunctionality");
       // landingPage = new LandingPage();
        landingPage.SelectLogout();
    }

}
