package ru.otus.selenium.support;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import ru.otus.selenium.components.CourseInfo;

import java.util.ArrayList;
import java.util.List;

@ScenarioScoped
public class DIScoped implements Cloneable {

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

  @Override
  public DIScoped clone() {
    try {
      DIScoped clone = (DIScoped) super.clone();
      // TODO: copy mutable state here, so the clone can't change the internals of the original
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
