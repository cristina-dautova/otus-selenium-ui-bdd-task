package ru.otus.selenium.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import ru.otus.selenium.factory.WebDriverFactory;
import ru.otus.selenium.support.DIScoped;

public class CommonSteps {

  @Inject
  public DIScoped diScoped;

  @Given("I opened {string} browser")
  public void openBrowser(String browser) {
    diScoped.setDriver(new WebDriverFactory().create(browser));
  }
}
