package com.pp.tenants.PageObjects;

import com.pp.tenants.Utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseClass {

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

    @FindBy(xpath = "//ul[@class=\"tree-children\"][@xpath=\"1\"]")
    WebElement list;

    @FindBy(xpath = "//div[@title=\"CKWUA90L\"]")
    WebElement listValue;

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
        String zero = randomStringGenerator();
        System.out.println("zero"+zero);
        name.sendKeys(zero);
       //name.sendKeys(randomStringGenerator());
        Thread.sleep(3000);
        List<WebElement> p =webDriver.findElements(By.xpath("//ul[@class=\"tree-children\"]/li[@class=\"tree-node tree-closed tree-leaf\"]"));
        for(WebElement x: p){
            System.out.println(x.getText());
            /*if(zero=x.getText()){
                webDriver.findElement(By.xpath())
                1. We got the elements from the list
                2. Compare both the elements same or not
                3. if both are same then delete
                4. else both are not same sout.
             */
            }
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
