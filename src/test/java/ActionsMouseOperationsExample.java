import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsMouseOperationsExample {

    WebDriver driver;

    @BeforeMethod
    public void mouseOperationsTestsBrowserOpen() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void mouseOperationsTests() {

        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("(01) Move to an Element");

        Actions actions = new Actions(driver);

        WebElement menu = driver.findElement(By.id("menuform:j_idt37"));

        actions.moveToElement(menu).perform();

        System.out.println("(02) Drag and Drop Operation");

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        // Method 1
        actions.clickAndHold(from)
                .moveToElement(to)
                .release()
                .perform();

        // Method 2 (direct)
        actions.dragAndDrop(from, to).perform();

        System.out.println("(03) Slider Operation");

        WebElement slider = driver.findElement(By.xpath("//div[@id='form:j_idt125']//span"));

        System.out.println("Before move: " + slider.getLocation());

        actions.dragAndDropBy(slider, 50, 0).perform();

        System.out.println("After move: " + slider.getLocation());
    }

    @Test
    public void mouseOperationsTest2() {

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        System.out.println("(04) Right Click");

        WebElement rightClickButton = driver.findElement(
                By.xpath("//span[@class='context-menu-one btn btn-neutral']")
        );

        Actions actions = new Actions(driver);

        actions.contextClick(rightClickButton).perform();

        driver.findElement(By.xpath("//span[text()='Edit']")).click();

        Alert alertPop = driver.switchTo().alert();

        System.out.println("Alert text: " + alertPop.getText());

        alertPop.accept();
    }
}