package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Guru99LoginFactory {

    /**

     * All WebElements are identified by @FindBy annotation

     */

    WebDriver driver;

    @FindBy(name="uid")
    WebElement user99GuruName;


    @FindBy(name="password")
    WebElement password99Guru;

    @FindBy(className="barone")
    WebElement titleText;



    @FindBy(name="btnLogin")
    WebElement login;



    public Guru99LoginFactory(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(factory, this);

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        user99GuruName.sendKeys(strUserName);



    }



    //Set password in password textbox

    public void setPassword(String strPassword){

        password99Guru.sendKeys(strPassword);

    }



    //Click on login button

    public void clickLogin(){

        login.click();

    }



    //Get the title of Login Page

    public String getLoginTitle(){

        return    titleText.getText();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToGuru99(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();



    }

}