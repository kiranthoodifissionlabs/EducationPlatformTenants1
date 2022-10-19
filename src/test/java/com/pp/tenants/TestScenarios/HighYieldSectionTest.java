package com.pp.tenants.TestScenarios;

import com.pp.tenants.PageObjects.HighYieldPage;
import com.pp.tenants.PageObjects.LandingPage;
import com.pp.tenants.Utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HighYieldSectionTest extends BaseClass {
    LandingPage landingPage;
    HighYieldPage highYieldPage;


    @Test(priority = 1)
    @Parameters({"url","username","password"})
    public void Verifyingtheloginfunctionality(String urlValue,String usernameValue, String passwordValue){
        extentTest.log(LogStatus.INFO,"Verifyingtheloginfunctionality");
        landingPage = new LandingPage();
        landingPage.login(urlValue,usernameValue,passwordValue);
    }
    @Test(priority = 2)
    public void createHighYieldSection(){
        highYieldPage = new HighYieldPage();
        highYieldPage.selecthighYieldCasesFromDashboard();
        highYieldPage.selectManageHighYieldSections();
        highYieldPage.clickOnCreateHighYieldSectionButton();
        highYieldPage.sendSectionName();
        highYieldPage.clickOnCreateButton();
    }
   @Test(priority = 3)
    public void deleteCreatedHighYieldSection(){
        highYieldPage = new HighYieldPage();
        highYieldPage.clickOnDeleteButton();
    }


}
