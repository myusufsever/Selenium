package tests.day09_actions;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void sagClicktesti(){

        //1- https://testotomasyonu.com/click sitesine gidin

        driver.get("https://testotomasyonu.com/click");
        ReusableMethods.bekle(1);
        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement dgiDrones=driver.findElement(By.xpath("//img[@id='pic2_thumb']"));
        actions.contextClick(dgiDrones).perform();

        ReusableMethods.bekle(2);
        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.


    String expectedAlertYazisi="Tebrikler!... Sağ click yaptınız.";

    String actualAlertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);
//Tamam diyerek Alert'i kapatalim
        driver.switchTo().alert().accept();















    }




}
