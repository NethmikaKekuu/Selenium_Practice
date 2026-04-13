import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class DownloadUploadFileExample {

    WebDriver driver;

    @BeforeMethod
    public void openFileTestsPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void fileDownloadTest() {

        driver.get("https://www.leafground.com/file.xhtml");

        WebElement downloadBtn = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadBtn.click();

        // Path to Downloads folder (IMPORTANT)
        String downloadPath = "C:\\Users\\nethm\\Downloads";

        File folder = new File(downloadPath);
        File[] files = folder.listFiles();

        boolean found = false;

        for (File f : files) {
            if (f.getName().contains(".png")) { // check downloaded file
                found = true;
                System.out.println("File is downloaded: " + f.getName());
                break;
            }
        }

        if (!found) {
            System.out.println("File not found in download folder");
        }
    }

    @Test
    public void fileUploadTest() throws AWTException {

        driver.get("https://www.leafground.com/file.xhtml");

        String filePath = "C:\\Users\\nethm\\Desktop\\11\\11.png";

        // 🔹 1st way - Using Robot Class (OS-level)
        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadBtn.click();

        // Copy file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();

        // Paste (CTRL + V)
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // 🔹 2nd way - Using sendKeys (BEST way)
        WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
        uploadInput.sendKeys(filePath);
    }
}