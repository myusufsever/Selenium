package tests.day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_IFrame extends TestBase {
    @Test
    public void test01(){

        //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //Cookies kabul edin
        // cookies de iframe icinde oldugundan
        // once o iframe'e gecis yapalim
        // WebElement cookiesIframe=driver.findElement(By.xpath("(//iframe)[4]"));
       // driver.switchTo().frame(cookiesIframe);
        // driver.findElement(By.xpath("//*[text()='Accept All']")).click();
        ReusableMethods.bekle(1 );

        //3) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrameList=driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfada ki iFrame sayisi : " + " " + iFrameList.size());
        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.


        WebElement iFrame=driver.findElement(By.tagName("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//button[@title='Oynat']")).click();

ReusableMethods.bekle(2);
        //5) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        ReusableMethods.bekle(8);









    }
}
