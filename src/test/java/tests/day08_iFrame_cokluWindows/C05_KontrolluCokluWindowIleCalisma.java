package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.net.Proxy;

public class C05_KontrolluCokluWindowIleCalisma extends TestBase {
@Test
public void kontrolluWindowTesti(){
    // Testotomasyonu anasayfaya gidin

    driver.get("https://www.testotomasyonu.com");
// url'in testotomasyonu icerdigini test edin

    ReusableMethods.bekle(2);

    String expectedUrl="testotomasyonu";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(expectedUrl));
    String anasayfaWHD=driver.getWindowHandle();
    ReusableMethods.bekle(2);


    // yeni bir tab olarak elctronics linkini acin
    driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");
    driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
    String electronicsWHD = driver.getWindowHandle();
     // acilan sayfanin electronics sayfasi oldugunu test edin
    // Title'da Electronics oldugunu test edelim

    String expectedIcerik="Electronic";
    String actualIcerik=driver.getTitle();

    Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    ReusableMethods.bekle(2);
    // yeni bir window'da acilacak sekilde menfashion linkini tiklayin

    driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");
    driver.findElement(By.xpath("(//a[text()='Men Fashion'])[3]")).click();
    String manfashionWHD=driver.getWindowHandle();

    // menfashion sayfasinin acildigini test edin
String   expectedTitleIcerik = "Men Fashion";
    String actualTitle = driver.getTitle();

    Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

    ReusableMethods.bekle(2);
    // ilk actigimiz sayfaya donun

    driver.switchTo().window(anasayfaWHD);

    // EGER bir test'de acilan windowlar farkli tab veya window'larda aciliyorsa
    // ve testimizde bu sayfalar arasinda gecis isteniyorsa
    // gectigimiz her sayfanin WindowHandleDegerini kaydetmeliyiz

    // test otomasyon anasayfada oldugumuzu test edin












}







}