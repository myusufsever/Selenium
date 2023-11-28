package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_DropdownMenu extends TestBase {
    @Test
    public void dropdowntesti() {
        //1. http://zero.webappsecurity.com/ Adresine gidin
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        WebElement loginKutusu = driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username");
        //4. Password kutusuna “password” yazin
        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");
        //5. Sign in tusuna basin, back tusuna basarak sayfaya donun
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        driver.navigate().back();
        //6. Online banking menusunden Pay Bills sayfasina gidin.
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. “Currency” dropdown menusunden Eurozone’u secin
        WebElement currencyDdm = driver.findElement(By.id("pc_currency"));
        Select selectCurrency = new Select(currencyDdm);
        selectCurrency.selectByValue("EUR");
        //9. “amount” kutusuna bir sayi girin
        WebElement amountElement = driver.findElement(By.id("pc_amount"));
        amountElement.sendKeys("100");
        //10. currency olarak “US Dollars” in secilmedigini test edin
        String unexpectedOptionYazisi = "US Dollars";
        String actualCurrencyOption = selectCurrency.getFirstSelectedOption().getText();

        Assert.assertNotEquals(unexpectedOptionYazisi, actualCurrencyOption);

        // Radio button  U.S. Dollars'in secilmedigini test edin
        WebElement UsdollarsButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(UsdollarsButton.isSelected());

        //11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();


        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        WebElement CalculateDdm = driver.findElement(By.id("pc_calculate_costs"));
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();


        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
WebElement yaziElementi=driver.findElement(By.id("alert_content"));
String expectedUyariElementi= "Foreign currency cash was successfully purchased.";
String actualUyariYazisi=yaziElementi.getText();

Assert.assertEquals(expectedUyariElementi,actualUyariYazisi);
        ReusableMethods.bekle(3);


    }
}