package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.awt.geom.RectangularShape;
import java.time.Duration;

public class C06_MethodIleDriverOlusturma {
WebDriver driver;
    public void driverOlustur() {
        WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void wisequarterTest(){
        driverOlustur();
        driver.get("https://www.wisequarter.com");
        //tittle'in "Wise" icerdiginiz test edin
        String expectedTitleIcerik="Wise";
        String actualTitleIcerik=driver.getTitle();

        if (actualTitleIcerik.contains(expectedTitleIcerik)){
            System.out.println("Wise test title PASSED");
        }
        else{
            System.out.println("Wise test title FAILED");
        }
        ReusableMethods.bekle(2);
        driver.quit();




    }


    @Test
    public void testOtomasyonuTest(){
        driverOlustur();
        // title'in "Test Otomasyon" icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        }else System.out.println("Test otomasyonu testi FAILED");
        ReusableMethods.bekle(1);
        driver.quit();


    }

@Test
public void googleTest(){
    driverOlustur();
    // google.com adresine gidin
    driver.get("https://www.google.com");
    // url'in "google" icerdigini test edin
    String expectedUrlIcerik = "google";
    String actualUrl = driver.getCurrentUrl();
    if (actualUrl.contains(expectedUrlIcerik)){
        System.out.println("Google testi PASSED");
    }else System.out.println("Google testi FAILED");
    ReusableMethods.bekle(1);
    driver.quit();
}











}
