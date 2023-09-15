import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDasAdvocaten {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.das.nl/werk-en-inkomen");
        driver.findElement(By.id("CybotCookiebotDialogBodyButtonAccept")).click();
        driver.manage().window().maximize();
    }
    @AfterMethod
        public void tearDown (){
        driver.quit();
    }
    @Test
    public void DienstenTest(){
        driver.findElement(By.xpath("//*[text()='Diensten']")).click();
        String expected = "Juridische dien\u00ADsten voor particulieren";
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='article__header']/h1")).getText(),expected);
     }
    @Test
    public void serviceEnContract(){
     driver.findElement(By.xpath("//*[text()='Service en contact']")).click();
     String expected = "Service en contact voor particulieren";
     Assert.assertEquals(driver.findElement(By.xpath("//*[@class='article__header']/h1")).getText(),expected);

    }


}
