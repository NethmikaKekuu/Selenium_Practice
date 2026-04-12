import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }

    @Test
    public void leafgroundpageDropDownTest() throws InterruptedException {

        // (1.1) Select value from dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select"));
        Select select = new Select(dropDown);

        select.selectByVisibleText("Playwright");
        Thread.sleep(2000);

        // (1.2) Get number of options
        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of elements in dropdown: " + size);

        for (WebElement element : listofOptions) {
            System.out.println(element.getText());
        }

        // (1.3) Using sendKeys
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(2000);

        // (1.4) Bootstrap dropdown (custom dropdown)
        WebElement dropdown2 = driver.findElement(By.id("j_idt87:country"));
        dropdown2.click();

        List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']"));

        for (WebElement element : options) {
            if (element.getText().equals("USA")) {
                element.click();
                break;
            }
        }
    }

    // (02) Google Search suggestions
    @Test
    public void googleSearchDropDown() throws InterruptedException {

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Nethmika");

        Thread.sleep(3000);

        List<WebElement> googlesearchList =
                driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@class='wM6W7d']"));

        for (WebElement element : googlesearchList) {
            System.out.println(element.getText());
        }
    }
}