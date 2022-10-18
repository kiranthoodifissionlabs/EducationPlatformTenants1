package com.pp.tenants.PageObjects;

import com.pp.tenants.Utility.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class MyPresentationspage extends BaseClass {

    public MyPresentationspage() {
        PageFactory.initElements(webDriver, this);
    }
}
