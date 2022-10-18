package com.pp.tenants.PageObjects;

import com.pp.tenants.Utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SlideLibraryPage extends BaseClass {

    public SlideLibraryPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[text()=' Slide Library ']")
    WebElement slidelibrary;




    @FindBy(xpath = "//span[text()='Diagnosis']")
    WebElement Diagnosis;

    public void selectSlidelibrary(){
        slidelibrary.click();
    }


    public void isDiagnosisradioButtonisDisplayed(){
        //Diagnosis.isDisplayed();
        if(Diagnosis.isDisplayed())
        {
            extentTest.log(LogStatus.PASS, "Upload button is displayed");
        }
        else
        {
            extentTest.log(LogStatus.FAIL, "Test Failed - Upload button is not displayed");
        }
    }

}
