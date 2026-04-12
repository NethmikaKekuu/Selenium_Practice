import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_CheckBox_Example {

    WebDriver driver;

    @BeforeMethod
    public void radio_checkbox_BeforeTests() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTests() {

        driver.get("https://www.leafground.com/radio.xhtml");

        // (1) Find default selected radio button
        List<WebElement> radioElements =
                driver.findElements(By.xpath("//table[@id='j_idt87:console2']//input"));

        int index = 0;

        for (WebElement radioElement : radioElements) {
            if (radioElement.isSelected()) {
                String labelXpath = "//label[@for='j_idt87:console2:" + index + "']";
                String text = driver.findElement(By.xpath(labelXpath)).getText();
                System.out.println("Default selected radio: " + text);
                break;
            }
            index++;
        }

        // (2) Select age group if not selected
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));

        if (!myAgeGroup.isSelected()) {
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }
    }

    @Test
    public void checkBoxTest() {

        driver.get("https://www.leafground.com/checkbox.xhtml");

        // (1) Select all except "Others"
        List<WebElement> checkBoxList =
                driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));

        for (WebElement element : checkBoxList) {
            if (!element.getText().equals("Others")) {
                element.click();
            }
        }

        // (2) Verify selection
        List<WebElement> inputs =
                driver.findElements(By.xpath("//table[@id='j_idt87:basic']//input"));

        for (WebElement input : inputs) {
            System.out.println(input.isSelected());
        }
    }
}