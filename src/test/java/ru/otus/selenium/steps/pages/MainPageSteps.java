package ru.otus.selenium.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import ru.otus.selenium.factory.WebDriverFactory;
import ru.otus.selenium.pages.MainPage;
import ru.otus.selenium.support.DIScoped;

public class MainPageSteps {

  @Inject
  public MainPage mainPage;

  @Given("I am on Main Page")
  public void openMainPage() {
    mainPage.open();
  }
}
