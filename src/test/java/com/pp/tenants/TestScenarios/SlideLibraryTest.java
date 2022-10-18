package com.pp.tenants.TestScenarios;

import com.pp.tenants.PageObjects.LandingPage;
import com.pp.tenants.PageObjects.SlideLibraryPage;
import com.pp.tenants.Utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SlideLibraryTest extends BaseClass {
    LandingPage landingPage;
    SlideLibraryPage slideLibraryPage;

    @Test(priority = 1)
    @Parameters({"url","username","password"})
    public void Verifyingtheloginfunctionality(String urlValue,String usernameValue, String passwordValue){
        extentTest.log(LogStatus.INFO,"Verifyingtheloginfunctionality");
        landingPage = new LandingPage();
        landingPage.login(urlValue,usernameValue,passwordValue);
    }
    @Test(priority = 2)
    public void VerifyingtheSlideLibraryfunctionality(){
        extentTest.log(LogStatus.INFO,"VerifyingtheSlideLibraryfunctionality");
        slideLibraryPage = new SlideLibraryPage();
        slideLibraryPage.selectSlidelibrary();
        slideLibraryPage.isDiagnosisradioButtonisDisplayed();
    }

    @Test(priority = 3)
    public void VerifytheLogoutFunctionality(){
        extentTest.log(LogStatus.INFO,"VerifytheLogoutFunctionality");
        landingPage.SelectLogout();
    }

    /*public void Verifyingtheloginfunctionality1(){

    }
    public void Verifyingtheloginfunctionality2(){

    }*/


}
