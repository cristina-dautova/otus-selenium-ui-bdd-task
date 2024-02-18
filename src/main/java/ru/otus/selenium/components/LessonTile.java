package ru.otus.selenium.components;

import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ru.otus.selenium.annotations.Component;
import ru.otus.selenium.components.staticcomponent.AbsBaseComponent;
import ru.otus.selenium.pages.LessonsPage;
import ru.otus.selenium.support.DIScoped;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component("section h2 ~ div a[href*='/lessons/']")
public class LessonTile extends AbsBaseComponent {

  private static final Logger LOGGER = LogManager.getLogger(LessonTile.class);
  private final DIScoped diScoped;
  private final Random random = new Random();

  @Inject
  public LessonTile(DIScoped scenarioScoped) {
    super(scenarioScoped);
    this.diScoped = scenarioScoped.clone();
  }

  public LessonsPage clickLessonTile(int number) {
    getComponentsEntity().get(--number).click();
    return new LessonsPage(diScoped);
  }

  public LessonsPage clickLessonTile(String tileName) {
    var tilesFilteredByName = getTilesByName(tileName);
    WebElement webElement;
    if (tilesFilteredByName.size() > 1) {
      webElement = tilesFilteredByName.get(random.nextInt(tilesFilteredByName.size()));
    } else {
      webElement = tilesFilteredByName.get(0);
    }
    ((JavascriptExecutor) diScoped.getDriver()).executeScript("arguments[0].scrollIntoView();", webElement);
    webElement.click();
    return new LessonsPage(diScoped);
  }

  public String getLessonTitle(int number) {
    return getComponentsEntity().get(--number).findElement(By.xpath(".//h5")).getText();
  }

  private List<WebElement> getTilesByName(String courseName) {

    return getComponentsEntity()
        .stream()
        .map(course -> course.findElement(By.xpath(".//h5")))
        .toList()
        .stream()
        .filter(childNode -> childNode.getText().contains(courseName))
        .collect(Collectors.toList());
  }

  public void showExpectedCourseNameAndDate(List<CourseInfo> filteredCourses) {
    filteredCourses
        .forEach(expectedCourseItem -> {
          LOGGER.info("Course name: " + expectedCourseItem.getCourseName() + "\n"
              + "Start date: " + expectedCourseItem.getDate());
        });
  }
  public List<CourseInfo> findCoursesAfterSpecificDate(String startDate) {

    var specificDate = parseDate(startDate);

    var regex = "^С (\\d{1,2} [а-я]+)";
    var pattern = Pattern.compile(regex);

    List<CourseInfo> filteredCourseInfoItems = new ArrayList<>();

    for (WebElement tile : getComponentsEntity()) {

      var calendarWebElement = tile.findElement(By.xpath(".//span[starts-with(text(),'С ')]"));
      var courseNameWebElement = tile.findElement(By.xpath(".//h5"));

      var matcher = pattern.matcher(calendarWebElement.getText());

      if (matcher.find()) {
        var parsedDate = parseDate(matcher.group(1));
        if (parsedDate.isEqual(specificDate) || parsedDate.isAfter(specificDate)) {

          var courseInfo = new CourseInfo();
          courseInfo.setDate(parsedDate);
          courseInfo.setCourseName(courseNameWebElement.getText());
          filteredCourseInfoItems.add(courseInfo);
        }
      }
    }
    return filteredCourseInfoItems;
  }

  private LocalDate parseDate(String date) {

    var dateFormat = new SimpleDateFormat("dd MMMM", new Locale("ru"));
    LocalDate localDate;
    try {
      localDate = dateFormat.parse(date)
          .toInstant()
          .atZone(dateFormat.getTimeZone().toZoneId())
          .toLocalDate();

    } catch (ParseException e) {
      throw new RuntimeException("Unable to parse date " + date);
    }
    return localDate.withYear(LocalDate.now().getYear());
  }
}
