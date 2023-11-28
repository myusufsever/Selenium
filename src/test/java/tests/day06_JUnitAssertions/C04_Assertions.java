package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    //) https://www.bestbuy.com/ Adresine gidin
    // farkli test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
@AfterClass
    public static void teardown(){
    driver.quit();

}
@Test
    public static void urlTesti(){

        driver.get("https://www.bestbuy.com/");
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
    Assert.assertTrue(actualUrl.equals(expectedUrl));
}
@Test
    public static void titleTesti(){
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

    String expectedTitle="Rest";
    String actualTitle=driver.getTitle();

    Assert.assertTrue(actualTitle.contains(expectedTitle))  ;


}
@Test
    public static void francaisLinkTesti() {


    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    WebElement francaisLinkElementi = driver.findElement(By.xpath("//*[text()='Français']"));

    Assert.assertTrue(((WebElement) francaisLinkElementi).isDisplayed());




}
}
