package pages;

/**
 * Created by vhorokho on 2017-07-06.
 */
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Guru99HomePageFactory {

    WebDriver driver;

    @FindBy(xpath="//table//tr[@class='heading3']")

    WebElement homePageUserName;



    public Guru99HomePageFactory(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(factory, this);
    }



    //Get the User name from Home Page

    public String getHomePageDashboardUserName(){

        return    homePageUserName.getText();

    }

}