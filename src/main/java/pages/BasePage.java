package pages;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    private static final Logger logger = LogManager.getLogger(String.valueOf(BasePage.class));
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
    public void setWebDriver(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
    }
    protected boolean elementExists(String xpath){
        try{
            logger.info("Check element with xpath exists" + xpath);
            webDriver.findElement(By.xpath(xpath));
            return true;
        }
        catch (Exception err){
            return false;
        }
    }
    protected WebElement findElementByXpath(String xpath){
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }
    protected WebElement findElementByRelativeLocator(String knownXpath, String relativeXpath){
        WebElement knownElement = webDriver.findElement(By.xpath(knownXpath));
         return webDriver.findElement(with(By.xpath(relativeXpath)).near(knownElement, 300));
    }
//    protected WebElement captureElement(String xpath){
//        WebElement capture = webDriver.findElement(By.xpath(xpath));
//        return (WebElement) capture.getScreenshotAs(OutputType.FILE);
//
//    }
    protected void captureElementScreenshot(WebElement element, String fileName){
        File screenshot = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(fileName));
        }
        catch (Exception err){
            throw new RuntimeException("\"Error while capturing screenshot: \" + e.getMessage(), e");
        }
    }
    protected void sendTextToElementByXpath(String xpath, String text){
        findElementByXpath(xpath).sendKeys(text);
    }

}
