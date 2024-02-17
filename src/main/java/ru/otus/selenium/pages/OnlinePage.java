package ru.otus.selenium.pages;

import com.google.inject.Inject;
import ru.otus.selenium.annotations.Path;
import ru.otus.selenium.support.DIScoped;

@Path("/online")
public class OnlinePage extends BasePage<OnlinePage> {

  @Inject
  public OnlinePage(DIScoped scenarioScoped) {
    super(scenarioScoped);
  }
}
