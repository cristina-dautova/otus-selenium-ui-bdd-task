package ru.otus.selenium.steps.pages;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import ru.otus.selenium.pages.LessonsPage;
import ru.otus.selenium.support.DIScoped;

public class LessonsPageSteps {

  @Inject
  public LessonsPage lessonsPage;
  @Inject
  public DIScoped diScoped;

  @And("I see correct course name")
  public void courseTitleIsDisplayed() {
    lessonsPage.pageHeaderShouldBeSameAs(diScoped.getLessonTitle());
  }

  @And("I see search word in course name")
  public void searchWordIsDisplayedInCourseTitle() {
    lessonsPage.pageHeaderShouldContain(diScoped.getLessonTitle());
  }

  @Then("I should be taken to Course Page")
  public void sendRequestButtonShouldBeVisible() {
    lessonsPage.headerSendRequestButtonShouldBeVisible();
  }
}
