package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
//1. userSholdLoginSuccessfullyWithValid Credentials




@Test
public void userShouldLoginSuccessfullyWithValid(){
    //* Enter “standard_user” username

    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    //* Enter “secret_sauce” password
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
//* Click on ‘LOGIN’ button
    driver.findElement(By.id("login-button")).click();

    //* Verify the text “PRODUCTS”
String expectedMessage = "Products";
    WebElement actualTextElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
    String actualMessage= actualTextElement.getText();
    Assert.assertEquals("Error Msg",expectedMessage,actualMessage);

}
//2. verifyThatSixProductsAreDisplayedOnPage


    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //* Enter “standard_user” username

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //* Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//* Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        //* Verify that six products are displayed on page

// String expectedMessage= "Sauce Labs Backpack";
//WebElement actualTextElement= driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
//String actualMessage= actualTextElement.getText();
//Assert.assertEquals("Error",expectedMessage,actualMessage);
        // Store elements in List<WebElement>
        List<WebElement> labelsListOfWebElements = driver.findElements(By.xpath("//div[@class='inventory_list']//div//div//div[@class='inventory_item_name']"));
        // System.out.println(labelsListOfWebElements);

        ArrayList<String> list = new ArrayList<>();

        for (WebElement element : labelsListOfWebElements) {
            //    System.out.println(element.getText());
            list.add(element.getText());
        }

        //System.out.println(list);

        //Actual
        int actual = list.size();
        //System.out.println("Actual: " + actual);

        String actual1 = Integer.toString(actual);
        //Expect
        int expected = 6;

        String expected1 = Integer.toString(expected);
        //Assert

        Assert.assertEquals("Number of items are not matching", expected1, actual1);




    }



    @After
    public void tearDown(){
        closeBrowser();
    }



}
