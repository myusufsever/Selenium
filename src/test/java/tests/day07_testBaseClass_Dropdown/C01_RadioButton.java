package tests.day07_testBaseClass_Dropdown;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_RadioButton {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
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
public void radioButtonKutuTesti(){
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Cinsiyet Radio button elementlerini locate edin ve
        //     radio buttonu isaretleyerek size uygun olani secin
        WebElement kadinRadioElementi=driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioELementi=driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioElementi=driver.findElement(By.id("inlineRadio3"));
        ReusableMethods.bekle(2);
       erkekRadioELementi.click();
        ReusableMethods.bekle(2);
        //	c. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(erkekRadioELementi.isSelected());
        Assert.assertFalse(kadinRadioElementi.isSelected());
        Assert.assertFalse(digerRadioElementi.isSelected());
        ReusableMethods.bekle(2);
    }
    @Test
    public void radioButtonYaziTesti(){
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //	b. Cinsiyet Radio button elementlerini locate edin ve
        //     yaziyi click ederek size uygun olani secin

        // secimi yazi ile yapabilirim
        // ama assertion'lar icin radio button'lara ihtiyacimiz var
        WebElement erkekRadioButtonYaziElementi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        erkekRadioButtonYaziElementi.click();
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        //	c. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(erkekRadioButton.isSelected());
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());
        ReusableMethods.bekle(2);
    }
    }








