import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class SampleTest {

    @Test
    public void testCase() throws InterruptedException {
        File file = new File("C:/Users/p998jfn/IdeaProjects/itacademy-autotests/chromedriver.exe");
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://contactform-swedbank.rhcloud.com/registration.html");

        WebElement surname = driver.findElement(By.id("inputSurname"));
        WebElement phone = driver.findElement(By.id("inputPhone"));

        WebElement bankDivision = driver.findElement(By.id("inputBankDivision"));
        WebElement button = driver.findElement(By.xpath("//input[contains(@value, 'Register')]"));
        WebElement name = driver.findElement(By.id("inputName"));
        WebElement en = driver.findElement(By.id("en"));
        WebElement lt = driver.findElement(By.id("lt"));
        WebElement date = driver.findElement(By.id("inputDate"));
        WebElement topic = driver.findElement(By.id("inputTopic"));
        WebElement email = driver.findElement(By.id("inputEmail"));
        WebElement comment = driver.findElement(By.id("inputOther"));

        button.click();
        en.click();
        lt.click();
        name.sendKeys("Vardas");
        surname.sendKeys("Pavarde");
        phone.sendKeys("860000000");
        date.sendKeys("2016-03-28 12:00");
        email.sendKeys("email@email.com");
        comment.sendKeys("komentarai");

        Select selectBank = new Select(bankDivision);
        Select selectTopic = new Select(topic);
        selectBank.selectByValue("Gedimino pr. 56");
        selectTopic.selectByValue("Taupymas ir investavimas");

        Thread.sleep(3000);

        WebElement submit = driver.findElement(By.xpath("//input[contains(@value, 'Siųsti')]"));
        submit.click();

        WebElement result = driver.findElement(By.xpath("//a[contains(@class,'col-xs-offset-10 col-xs-2 btn btn-primary ng-binding')]"));
        Assert.assertEquals(result.getAttribute("href"), "http://contactform-swedbank.rhcloud.com/index.html");
        driver.quit();
    }
}