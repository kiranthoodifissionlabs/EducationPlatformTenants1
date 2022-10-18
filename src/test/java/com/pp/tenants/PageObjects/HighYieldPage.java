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














}
