/**
 * Created by vhorokho on 2017-07-05.
 */

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pages.Guru99HomePage;

import pages.Guru99Login;

public class TestGuru99Login {

    WebDriver driver;

    Guru99Login objLogin;

    Guru99HomePage objHomePage;


    @BeforeTest

    public void setup() {
        File file = new File("C:/java/guru99/src/main/resources/driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");

    }

    /**
     * This test case will login in http://demo.guru99.com/V4/
     * <p>
     * Verify login page title as guru99 bank
     * <p>
     * Login to application
     * <p>
     * Verify the home page using Dashboard message
     */

    @Test
    public void justAssert(){
        Assert.assertEquals(2,2);
    }

    @Test
    public void justAssert2(){
        Assert.assertEquals(2,2);
    }

    @Test(priority = 0)

    public void test_Home_Page_Appear_Correct() {

        //Create Login Page object

        objLogin = new Guru99Login(driver);

        //Verify login page title

        String loginPageTitle = objLogin.getLoginTitle();

        Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

        //login to application

        objLogin.loginToGuru99("mngr86453", "hYpYdur");

        // go the next page

        objHomePage = new Guru99HomePage(driver);

        //Verify home page

        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr86453!"));

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}