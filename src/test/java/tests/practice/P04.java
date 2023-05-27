package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Saucedemopage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Arrays;

public class P04 {

        /*
Navigate to https://www.saucedemo.com/
Enter the username as standard_user
Enter the password as secret_sauce
Click on login button
Test 1: Choose price low to high
Test 2:Verify item prices are sorted from Iow to high with soft Assert

     */

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("sauceDemoUrl"));

        Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");

        Saucedemopage saucedemopage = new Saucedemopage();
        saucedemopage.sifre.sendKeys("secret_sauce");
        saucedemopage.loginButton.click();

        Select select = new Select(saucedemopage.drapdownMenu);
        select.selectByVisibleText("Price (low to high)");

        // test2 : Verify item prices are sorted from Iow to high with soft Assert
        double[] prices = {7.99, 9.99, 15.99, 15.99, 29.99, 49.99};
        SoftAssert softAssert = new SoftAssert();
        Arrays.sort(prices);
        System.out.println(Arrays.toString(prices));

        // fiyatların sıralı olup olamsığını
        for (int i = 0; i < prices.length - 1; i++) {
            softAssert.assertTrue(prices[i] <= prices[i + 1]);
        }

        softAssert.assertAll();
     Driver.closeDriver();
    }


}
