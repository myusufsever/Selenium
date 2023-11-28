package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebappTesti {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. http://zero.webapps //2. Signin buttonuna tiklayinecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        //3. Login alanina  “username” yazdirin
      WebElement username= driver.findElement(By.id("user_login"));
      username.sendKeys("username");
      WebElement password=driver.findElement(By.id("user_password"));
      password.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountkutu=driver.findElement(By.id("sp_amount"));
        amountkutu.sendKeys("500");
        //9. tarih kismina “2023-09-10” yazdirin
        WebElement tarihkutu=driver.findElement(By.id("sp_date"));
        tarihkutu.sendKeys("2023-09-10");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement content=driver.findElement(By.id("alert_content"));
        String expectedtittle="The payment was successfully submitted.";
        String actualtitle=content.getText();
        if (actualtitle.equals(expectedtittle)){
            System.out.println("Payment  testi PASSED");

        }else{
            System.out.println("Payment testi FAILED");
        }









        Thread.sleep(2000);

        driver.close();









    }
}
