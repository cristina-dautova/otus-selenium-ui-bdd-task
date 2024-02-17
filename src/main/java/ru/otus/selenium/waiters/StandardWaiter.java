package ru.otus.selenium.waiters;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@AllArgsConstructor
public class StandardWaiter {

  private WebDriver driver;

  public boolean waitForCondition(ExpectedCondition expectedCondition) {
    try {
      new WebDriverWait(this.driver, Duration.ofSeconds(15)).until(expectedCondition);
      return true;
    } catch (Exception ignored) {
      return false;
    }
  }

  public boolean isVisible(WebElement webElement) {
    return waitForCondition(ExpectedConditions.visibilityOf(webElement));
  }

  public boolean isVisible(List<WebElement> webElement) {
    return waitForCondition(ExpectedConditions.visibilityOfAllElements(webElement));
  }
}
