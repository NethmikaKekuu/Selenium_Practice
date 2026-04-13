import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BrokenImageExample {

    WebDriver driver;

    @BeforeMethod
    public void openImagePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void findBrokenImageTest() {

        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images = driver.findElements(By.tagName("img"));

        int i = 1;

        for (WebElement image : images) {

            // Use JavaScript property (important)
            Long width = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalWidth;", image);

            if (width == 0) {
                System.out.println("Image " + i + " is BROKEN");
            } else {
                System.out.println("Image " + i + " is NOT broken");
            }

            i++;
        }
    }
}