package com.pp.tenants.PageObjects;

import com.pp.tenants.Utility.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HighYieldPage extends BaseClass {

    public HighYieldPage() {
        PageFactory.initElements(webDriver, this);
    }



    @FindBy(xpath = "//div[text()=' High Yield Cases ']")
    WebElement highYield;

    @FindBy(xpath = "//div[text()=' High Yield Sections ']")
    WebElement highYieldSections;

    @FindBy(xpath = "//div[text()=' Manage High Yield Sections ']")
    WebElement manageHighYieldSections;

    @FindBy(xpath = "//button[@class=\"btn btn btn-outline-primary btn-sm pull-right btn-outline-primary\"]")
    WebElement createHighYieldSection;

    @FindBy(xpath = "//input[@name=\"section name\"]")
    WebElement sectionName;

    @FindBy(xpath = "//span[contains(text(),\"Create\")]")
    WebElement createButton;

    @FindBy(xpath = "(//button[@title=\"Delete High Yield Section\"])[1]")
    WebElement deleteHighYieldSelection;


    public void selecthighYieldCasesFromDashboard(){
        highYield.click();
    }
    public void selectManageHighYieldSections(){
        manageHighYieldSections.click();
    }
    public void clickOnCreateHighYieldSectionButton(){
        createHighYieldSection.click();
    }

    public void sendSectionName() {
        String sectionNameValue = randomStringGenerator();
        sectionName.sendKeys(sectionNameValue);
    }

    public void clickOnCreateButton(){
        createButton.click();
    }


    public void clickOnDeleteButton() {
        deleteHighYieldSelection.click();
    }


















}
