package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class P3 {

    //    - beforeClass oluşturup setUp ayarlarini yapin.
    //    - Birbirine bağımlı testler oluşturarak
    //    - ilk once wisequarte'a gidin
    //    - sonra wisequarter'a bağımlı olarak youtube'a gidin
    //    - daha sonra youtube'a bağımlı olarak amazon' a gidin
    //    - driver'i kapatın.
    //    //- beforeClass oluşturup setUp ayarlarini yapin.

    //  - Birbirine bağımlı testler oluşturun.
    static WebDriver driver;
/*
    @BeforeClass
    public static void test01(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

 */
 @Test
    public void wisequarter(){

     Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
 }

@Test
    public void youtube(){
     Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
}
@Test
    public void amazon(){
     Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
}






}
