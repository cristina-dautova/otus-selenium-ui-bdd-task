package ru.otus.selenium.support;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import ru.otus.selenium.components.CourseInfo;

import java.util.ArrayList;
import java.util.List;

@ScenarioScoped
public class DIScoped {

  @Getter
  @Setter
  private String browser;
  @Getter
  @Setter
  private WebDriver driver;
  @Getter
  @Setter
  private String lessonTitle;

  private List<CourseInfo> coursesInfo;
  public void setCoursesInfo(List<CourseInfo> coursesInfo) {
    this.coursesInfo =  new ArrayList<>(coursesInfo);
  }

  public List<CourseInfo> getCoursesInfo() {
    return new ArrayList<>(coursesInfo);
  }
}
