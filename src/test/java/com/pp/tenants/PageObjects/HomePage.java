package com.pp.tenants.PageObjects;

import com.pp.tenants.Utility.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    public HomePage() {
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(xpath="//button[text()='Dashboard']")
    WebElement dashboard;

    @FindBy(xpath = "//a[text()=' My SlideBox']")
    WebElement SlideBox;

    @FindBy(xpath = "//button[@class='btn btn-link text-light btn-sm']")
    WebElement CreateFolder;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//button[@title='Upload']")
    WebElement upload;

    @FindBy(xpath = "//button[@title='Radiology']")
    WebElement  radiology;

    @FindBy(xpath = "//span[text()='Create']")
    WebElement clickcreatebutton;

    public void selectCreatebutton(){
        clickcreatebutton.click();
    }


    public void SelectDashboard(){
        dashboard.click();
    }

    public void SelectSlideBox(){
        SlideBox.click();
    }
    public void selectCreateFolder(){
        CreateFolder.click();
    }
    public void selectName() throws InterruptedException {
        name.sendKeys(randomStringGenerator());
        Thread.sleep(3000);
        //System.out.println(randomStringGenerator());
    }
    public void createFolder() throws InterruptedException {
        selectCreateFolder();
        selectName();
        selectCreatebutton();
    }

    public void isUploadButtonisDisplayed(){
        //upload.isDisplayed();
        if(upload.isDisplayed())
        {
           extentTest.log(LogStatus.PASS, "Upload button is displayed");
        }
        else
        {
            extentTest.log(LogStatus.FAIL, "Test Failed - Upload button is not displayed");
        }
    }

    public void isRadiologyButtonisDisplayed(){
       // radiology.isDisplayed();
        if(radiology.isDisplayed())
        {
            extentTest.log(LogStatus.PASS, "Radiology button is displayed");
        }
        else
        {
            extentTest.log(LogStatus.FAIL, "Test Failed - Radiology button is not displayed");
        }
    }






}
