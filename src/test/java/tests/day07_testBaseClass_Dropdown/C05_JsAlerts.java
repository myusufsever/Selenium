package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_JsAlerts extends TestBase {

    //3 test method'u olusturup asagidaki gorevi tamamlayin

    @Test
    public void jsBasicAlert() {
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick = 'jsAlert()']")).click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertyazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertyazisi, actualAlertYazisi);

        //	-  OK tusuna basip alert'i kapatin
        ReusableMethods.bekle(3);
        driver.switchTo().alert().accept();

    }

    @Test
    public void jsConfirmAlert() {
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //	- 2.alert'e tiklayalim jsConfirm()
        driver.findElement(By.xpath("//*[@onclick = 'jsConfirm()']")).click();
        //	- Cancel'a basip,

        ReusableMethods.bekle(2);

        driver.switchTo().alert().dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedResultYazisi = "You clicked: Cancel";
        String actualResultYazisi = resultYaziElementi.getText();

        Assert.assertEquals(expectedResultYazisi, actualResultYazisi);


    }
    @Test
    public void jsPromptTesti(){

        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin










    }
}