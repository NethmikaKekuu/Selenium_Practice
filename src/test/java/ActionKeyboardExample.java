import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ActionKeyboardExample {

    WebDriver driver;

    @BeforeMethod
    public void keyboardOperationsTestsBrowserOpen() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void keyboardActionsTest1() {

        driver.get("https://www.google.com/");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
        googleSearchTextBox.sendKeys("welcome");

        Actions actions = new Actions(driver);

        // Select all text (CTRL + A)
        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();

        // Type uppercase text using SHIFT
        actions.keyDown(Keys.SHIFT)
                .sendKeys(" writing capital sentence")
                .keyUp(Keys.SHIFT)
                .perform();

        // Select all and cut (CTRL + A, CTRL + X)
        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("x")
                .keyUp(Keys.CONTROL)
                .perform();

        // Type in uppercase directly into textbox
        actions.keyDown(googleSearchTextBox, Keys.SHIFT)
                .sendKeys("Nethmika Kekulanthale")
                .keyUp(Keys.SHIFT)
                .perform();
    }

    @Test
    public void keyboardActionsTest2() {

        driver.get("https://www.leafground.com/list.xhtml");

        List<WebElement> selectable = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        System.out.println("List size: " + selectable.size());

        Actions actions = new Actions(driver);

        // Multi-select using CTRL
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .keyUp(Keys.CONTROL)
                .perform();
    }
}