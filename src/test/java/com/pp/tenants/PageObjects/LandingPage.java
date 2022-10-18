package com.pp.tenants.PageObjects;

import com.pp.tenants.Utility.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends TestBase {
    public LandingPage() {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(name = "email")
    WebElement userName;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//span[contains(text(),\"Login\")]")
    WebElement loginBtn;

    @FindBy(xpath = "//img[@class=' pp-thumbnail-2']")
    WebElement profile;

    @FindBy(xpath = "//i[@class='fa fa-sign-out']")
    WebElement signout;

    public void Selectprofile(){
        profile.click();
    }
    public void clickLogout(){
        signout.click();
    }

    public void SelectLogout(){
        Selectprofile();
        clickLogout();
    }

    public String validateLoginPageTitle() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return webDriver.getTitle();
    }

    public void selectLoginLink() {
        loginBtn.click();
    }

    public void login(String url,String un, String pwd) {
        webDriver.get(url);
        userName.sendKeys(un);
        password.sendKeys(pwd);
        selectLoginLink();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
