package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_TestNotasyonu {
    // bir class'in icinde birden fazla bagimsiz calisabilen test olur mu ?
    // JUnit ile calisirken class'da birden fazla test oldugunda
    // toplu calistirdigimiz zaman hangi sira ile calisacagini BILEMEYIZ ve KONTROL EDEMEYIZ

@Test
    public  void testOtomasyonuTest(){ //Test metodlari static olmamalidir.
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    // testotomasyonu.com adresine gidin
         driver.get("https://www.testotomasyonu.com");
    // title'in "Test Otomasyon" icerdigini test edin
    String expectedTittle="Test Otomasyon";
    String actualTittle=driver.getTitle();
    if (actualTittle.equals(expectedTittle)){
        System.out.println("Test PASSED");
    }else{
        System.out.println("Test FAILED");
    }

    ReusableMethods.bekle(3);
driver.quit();

}
@Test
public void googleTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // google.com adresine gidin
        driver.get("https://www.google.com");
        // url'in "google" icerdigini test edin
        String expectedUrlIcerik = "google";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Google testi PASSED");
        } else System.out.println("Google testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();


    }



    @Test
    public void wisequarterTest(){

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    // wisequarter.com adresine gidin

        driver.get("https://www.wisequarter.com");

        //title'in "Wise"" icerdigini  test edin

        String expectedTittle="Wise";
        String actualTittle=driver.getTitle();

        if (actualTittle.contains(expectedTittle)){

            System.out.println("Tittle test PASSED");

        }else {
            System.out.println("Tittle test FAILED");
        }
ReusableMethods.bekle(1);
        driver.quit();





    }



}
