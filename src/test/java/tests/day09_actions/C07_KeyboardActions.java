package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.security.Key;

public class C07_KeyboardActions extends TestBase {
@Test
public void test01(){

    //2- https://www.testotomasyonu.com sayfasina gidelim
    driver.get("https://www.testotomasyonu.com");
    //3- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin
    //   ve Enter’a basarak arama yaptirin

    WebElement aramaKutusuElementi=driver.findElement(By.id("global-search"));

    Actions actions=new Actions(driver);

    actions.click(aramaKutusuElementi);

    actions
            .keyDown(Keys.SHIFT)
            .sendKeys("dell c")
            .keyUp(Keys.SHIFT)
            .sendKeys("ore")
            .keyDown(Keys.SHIFT)
            .sendKeys(" i")
            .keyUp(Keys.SHIFT)
            .sendKeys("3")
            .perform();

actions.sendKeys(Keys.ENTER).perform();


    ReusableMethods.bekle(2);
    //4- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
    WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']"));

    String expectedIsimIcerigi= "DELL Core I3";
    String actualUrunIsmi = urunIsimElementi.getText();

    Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));

    ReusableMethods.bekle(1);
}


}
