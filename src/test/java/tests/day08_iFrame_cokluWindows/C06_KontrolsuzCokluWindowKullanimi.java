package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C06_KontrolsuzCokluWindowKullanimi extends TestBase {
    @Test
    public void test01() {

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get(" https://testotomasyonu.com/addremove/");
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.

        WebElement yaziElementi = driver.findElement(By.xpath("//h2[text()='Add/Remove Elements']"));
        String expectedIcerik = "Add/Remove Elements";
        String actualIcerik = yaziElementi.getText();
        Assert.assertEquals(expectedIcerik, actualIcerik);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.

        String expectedTitles = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitles, actualTitle);

        ReusableMethods.bekle(1);

        //● ’Please click for Electronics Products’ linkine tiklayin.

        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
  /*
            Driver bir webelement'e click yapildiginda
            ayni sayfada acilacagini varsayar

            eger tiklanan element yeni bir tab veya window aciyorsa
            bu durumda driver'i yeni acilan tab/window'a bizim gondermemiz gerekir

            bizim driver'i baska bir tab/window'a yollamak icin 2 yolumuz var
            1- ya kontrollu yeni bir tab/window acarak
            2- kontrolsuz acilan tab/window'un Window handle degerini kullanarak

            Burada Java'dan yaralanarak mini bir bulmaca cozmeliyiz
         */

        String ilksayfaWHD = driver.getWindowHandle();
        Set<String> wHDSeti = driver.getWindowHandles();
        String ikincisayfaWHD = "";
        for (String each : wHDSeti
        ) {
            if (!each.equals(ilksayfaWHD))
                ikincisayfaWHD = each;

    }
        driver.switchTo().window(ikincisayfaWHD);
        String expectedTitle="Electronics";
        actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));




        //● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucyaziElementi=driver.findElement(By.xpath("//span[@class='product-count-text']"));


        String sonucSayisiStr=sonucyaziElementi.getText().replaceAll("\\D","" );
        int actualSonucSayisi=Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi=16;
        Assert.assertEquals(actualSonucSayisi,expectedSonucSayisi);
        //● Ilk actiginiz addremove sayfasina donun

        driver.switchTo().window(ilksayfaWHD);
        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        System.out.println(wHDSeti);

        ReusableMethods.bekle(3);








    }





}
