package ru.otus.selenium.utils;

import com.google.inject.Inject;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.otus.selenium.ApplicationConfig;
import ru.otus.selenium.support.DIScoped;
import ru.otus.selenium.waiters.StandardWaiter;

public abstract class BaseUtils {

  public static final ApplicationConfig APPLICATION_CONFIG = ConfigFactory
      .create(ApplicationConfig.class, System.getProperties());
  protected WebDriver driver;
  protected StandardWaiter standardWaiter;

  @Inject
  public BaseUtils(DIScoped scenarioScoped) {
    this.driver = scenarioScoped.getDriver();
    PageFactory.initElements(driver, this);
    this.standardWaiter = new StandardWaiter(driver);
  }
}
