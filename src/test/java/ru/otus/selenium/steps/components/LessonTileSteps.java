package ru.otus.selenium.steps.components;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.Setter;
import ru.otus.selenium.components.CourseInfo;
import ru.otus.selenium.components.LessonTile;
import ru.otus.selenium.support.DIScoped;

import java.util.List;

public class LessonTileSteps {

  @Inject
  public LessonTile lessonTile;
  @Inject
  public DIScoped diScoped;

  @When("I click course tile {int}")
  public void clickLessonByNumber(int number) {
    diScoped.setLessonTitle(lessonTile.getLessonTitle(number));
    lessonTile.clickLessonTile(number);
  }

  @When("I click course tile containing {string}")
  public void clickLessonByName(String courseName) {
    diScoped.setLessonTitle(courseName);
    lessonTile.clickLessonTile(courseName);
  }

  @When("I search courses starting from the date {string}")
  public void showCoursesInfoAfterSpecificDate(String startDate) {
    var filteredCourses = lessonTile.findCoursesAfterSpecificDate(startDate);
    diScoped.setCoursesInfo(filteredCourses);
  }

  @Then("I see courses information in console")
  public void printCoursesInfoInConsole() {
    lessonTile.showExpectedCourseNameAndDate(diScoped.getCoursesInfo());
  }
}
