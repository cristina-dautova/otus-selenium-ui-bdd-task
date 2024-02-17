package ru.otus.selenium.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ru.otus.selenium.pages.OnlinePage;

public class OnlinePageSteps {

  @Inject
  private OnlinePage onlinePage;

  @Given("I am on Online Page")
  public void openOnlinePage() {
    onlinePage.open();
  }
}
