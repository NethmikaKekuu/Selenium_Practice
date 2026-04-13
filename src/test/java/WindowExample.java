import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowExample {

    WebDriver driver;

    @BeforeMethod
    public void windowTestsPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Better than Thread.sleep
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void windowTests() {

        // (01) Store parent window
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);

        // Click button to open new window
        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        openButton.click();

        // Get all window handles
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handles size: " + handles.size());

        // Switch to child window (skip parent)
        for (String window : handles) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Child title: " + driver.getTitle());
                driver.close(); // close child
            }
        }

        // Switch back to parent
        driver.switchTo().window(parentWindow);

        // Verify parent still active
        System.out.println("Back to Parent: " + driver.getTitle());

        // (02) Count number of opened tabs
        WebElement multiWindow = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        multiWindow.click();

        Set<String> multiWindows = driver.getWindowHandles();
        System.out.println("No of windows opened: " + multiWindows.size());

        // (03) Close all except parent
        WebElement dontCloseMe = driver.findElement(By.id("j_idt88:j_idt93"));
        dontCloseMe.click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }

        // Switch back to parent at the end
        driver.switchTo().window(parentWindow);

        // Close everything
        driver.quit();
    }
}
