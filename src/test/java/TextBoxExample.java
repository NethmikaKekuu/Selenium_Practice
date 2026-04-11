import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxTests(){
        //(01) Type of name
        driver.findElement(By.id("j_idt88:name")).sendKeys("Nethmika Kekulanthale");

        //(02) Append Country to this city
        driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("Sri Lanka");

        //(03) Verify if text box is disabled
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box enabled" + enabled);

        //(04) Clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.click();

        //(05) Retreive the typed text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        //(06) Type email and Tab. Confirm control moved to next element
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("ne@gamil.com" + Keys.TAB + "confirmed control moved to next element");


    }
}
