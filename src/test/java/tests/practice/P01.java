package tests.practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import javax.swing.*;
import java.util.List;

public class P01 extends TestBaseRapor {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Amazon arama testi","Amazon daki elementleri kontrol eder");
        //Ø AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda
        //bana hucredeki yaziyi getirecek bir method olusturun


        //TestNG Genel Tekrar Soru Cozumu
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gider");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();
        extentTest.info("kullanıcı sayfanın en altına gider");
        AmazonPage amazonPage=new AmazonPage();
        System.out.println(amazonPage.dataGetir(3, 2));
        SoftAssert softAssert=new SoftAssert();

        //Ø Tests paketi altinda yeni bir class olusturun: D26_AmazonHucreTesti
        //Ø Bu class’in altinda bir test method olusturun : hucretesti( ) ve webtable’da
        //3. satir 2.sutundaki yazinin “Home Services” yazisi icerdigini test edin
        String expectedIcerik="Home Services";
        String actualSonuc=amazonPage.dataGetir(3,3);
        softAssert.assertTrue(actualSonuc.contains(expectedIcerik));
        extentTest.pass("Home Services yazisinin bulunduğunu test eder");

        //Ø Yeni bir method olusturun : AmazonYazisi( ) ve tabloda 9 Hucrede
        //“Amazon” yazisi bulundugunu test edin
        System.out.println(amazonPage.tabloList.size());
        List<String> actualList=ReusableMethods.stringListeCevir(amazonPage.tabloList);
        String expectedTabloIcerik="Amazon";
        int flag=0;
        for (String eachData: actualList
             ) {
            if(eachData.contains(expectedTabloIcerik)){
                flag++;
            }
        }

        int actualAmazonIcerik=flag;
        int expectedAmazonIcerik=9;
     softAssert.assertEquals(actualAmazonIcerik,expectedAmazonIcerik);
        extentTest.pass("Amazon page sayfasinı test eder");
        softAssert.assertAll();
        Driver.closeDriver();
    }

}
