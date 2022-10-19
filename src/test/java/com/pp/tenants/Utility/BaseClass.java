package com.pp.tenants.Utility;

import com.pp.tenants.Config.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    protected static WebDriver webDriver;
    protected static Properties prop;
    static String absPath = System.getProperty("user.dir");
    private static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public BaseClass() {
        try {
            prop = new Properties();
            System.out.println(absPath);
            FileInputStream ip = new FileInputStream(absPath + "\\src\\test\\java\\com\\pp\\tenants\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(chromeOptions);
            //webDriver=new ChromeDriver();
        } else if (browserName.equals("FF")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public static String CaptureScreen(WebDriver driver) throws IOException {
        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Destinationfile = new File(absPath + "\\screenshots\\screenshot" + System.currentTimeMillis() + ".png");
        String absolutepath_screen = Destinationfile.getAbsolutePath();
        FileUtils.copyFile(scrfile, Destinationfile);
        return absolutepath_screen;
    }

    protected String randomStringGenerator() {
        String VALUES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * VALUES.length());
            sb.append(VALUES.charAt(index));
        }
        String saltStr = sb.toString();
        return saltStr;
    }

    protected String titleValidation(String title) {
        //System.out.println(title);
        Boolean isTitleExists = false;
        String[] VALUES = {"Pathpresenter public", "ASDP-VSL"};
        for (int i = 0; i < VALUES.length; i++) {
            if (VALUES[i].equals(title)) {
               // System.out.println("nininni"+ title);
                isTitleExists = true;
            }
        }
        return isTitleExists ? title : null;
    }

  @BeforeClass
    public static void startTest() {
      extentReports = new ExtentReports(absPath + "\\report\\report.html", false);
      extentTest = extentReports.startTest("Education platform Report");
  }

      @BeforeTest
    public void setUp(){
        initialization();
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
       // extentReports.endTest(extentTest);
        //extentReports.flush();
    }

    @AfterClass
    public void tearreport(){
        extentReports.endTest(extentTest);
        extentReports.flush();
    }



}
