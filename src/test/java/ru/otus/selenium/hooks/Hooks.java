package ru.otus.selenium.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.otus.selenium.support.DIScoped;

public class Hooks {

  @Inject
  public DIScoped diScoped;

  @After
  public void close() {
    WebDriver driver = diScoped.getDriver();
    if (driver != null) {
      driver.close();
      if (driver instanceof ChromeDriver) {
        driver.quit();
      }
    }
  }
}
