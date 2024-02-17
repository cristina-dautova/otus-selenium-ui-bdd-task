
package ru.otus.selenium.factory;

import org.openqa.selenium.WebDriver;
import ru.otus.selenium.exceptions.BrowserNotSupportedException;
import ru.otus.selenium.factory.driver.ChromeDriverConfiguration;
import ru.otus.selenium.factory.driver.FirefoxDriverConfiguration;

public class WebDriverFactory implements IFactory<WebDriver> {

  @Override
  public WebDriver create(String browser) {

    switch (browser) {
      case "chrome":
        return new ChromeDriverConfiguration().configure();
      case "firefox":
        return new FirefoxDriverConfiguration().configure();
      default:
        throw new BrowserNotSupportedException(browser);
    }
  }
}
