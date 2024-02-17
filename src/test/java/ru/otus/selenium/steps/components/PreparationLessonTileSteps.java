package ru.otus.selenium.steps.components;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import ru.otus.selenium.components.PreparationLessonTile;

public class PreparationLessonTileSteps {

  @Inject
  public PreparationLessonTile preparationLessonTile;

  @Then("I see course with {string} price value")
  public void getCourseInfo(String minOrMax) {
    preparationLessonTile.getCourseInfoByPrice(minOrMax);
  }
}
