# Selenium WebDriver TestNG Examples

A collection of hands-on Selenium WebDriver test examples written in Java using the TestNG framework. This repository covers a wide range of real-world UI automation scenarios.

---

## 📁 Project Structure

| Class | Description |
|---|---|
| `OpenGoogleTest` | Basic smoke test — opens Google and searches for a keyword |
| `ButtonExample` | Button interactions: click, position, color, size |
| `TextBoxExample` | Text input, clearing, disabling, tab navigation |
| `DropDownExample` | Standard `<select>` dropdowns, Bootstrap dropdowns, Google search suggestions |
| `Radio_CheckBox_Example` | Radio button detection, checkbox selection and verification |
| `AlertExample` | Simple, confirm, and prompt alert handling |
| `FrameExample` | Switching between iframes and nested frames |
| `WindowExample` | Multi-window/tab handling, switching, and closing |
| `LinkExample` | Link navigation, broken link detection, counting page links |
| `ActionKeyboardExample` | Keyboard actions: CTRL+A, SHIFT typing, cut, multi-select |
| `ActionsMouseOperationsExample` | Mouse actions: hover, drag & drop, slider, right-click |
| `DownloadUploadFileExample` | File download verification and file upload (Robot Class + sendKeys) |
| `BrokenImageExample` | Detecting broken images using JavaScript `naturalWidth` |

---

## 🛠 Tech Stack

- **Language:** Java
- **Browser Automation:** Selenium WebDriver 4.x
- **Test Framework:** TestNG
- **Browser:** Google Chrome (ChromeDriver)

---

## ⚙️ Prerequisites

- Java JDK 11 or higher
- Maven or Gradle (for dependency management)
- Google Chrome browser installed
- ChromeDriver matching your Chrome version (or use WebDriverManager)

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

### 2. Add dependencies (Maven)

Add the following to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.x.x</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.x.x</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### 3. Run tests

Run all tests using Maven:

```bash
mvn test
```

Or run a specific class in your IDE using the TestNG plugin.

---

## 📝 Notes

- `DownloadUploadFileExample` uses hardcoded local file paths (`C:\Users\nethm\...`). Update these to match your machine before running.
- Tests use `implicitlyWait` for synchronization. For production use, explicit waits (`WebDriverWait`) are recommended.
- No `@AfterMethod` teardown is included in most classes. Adding `driver.quit()` in an `@AfterMethod` is advised to avoid browser leaks.

---

## 🌐 Test Sites Used

- [leafground.com](https://www.leafground.com) — practice site for Selenium
- [the-internet.herokuapp.com](https://the-internet.herokuapp.com) — broken images
- [swisnl.github.io/jQuery-contextMenu](https://swisnl.github.io/jQuery-contextMenu/demo.html) — right-click menu
- [google.com](https://www.google.com) — search functionality

---

## 👤 Author

**Nethmika Kekulanthale**
