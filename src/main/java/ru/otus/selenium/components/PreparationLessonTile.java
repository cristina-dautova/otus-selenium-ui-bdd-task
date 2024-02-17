package ru.otus.selenium.components;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import ru.otus.selenium.annotations.Component;
import ru.otus.selenium.components.staticcomponent.AbsBaseComponent;
import ru.otus.selenium.support.DIScoped;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component("div a[href*='/online/']")
public class PreparationLessonTile extends AbsBaseComponent {

  @Inject
  public PreparationLessonTile(DIScoped scenarioScoped) {
    super(scenarioScoped);
  }

  private List<Map.Entry<String, Integer>> getAllPricesInfo() {

    var regexGetNumbers = "\\d+";
    var pattern = Pattern.compile(regexGetNumbers);

    return getComponentsEntity()
        .stream()
        .map(
            course -> {
              var price = course.findElement(By.cssSelector("div [class='lessons__new-item-price']")).getText();
              var title = course.findElement(By.cssSelector("div [class*='lessons__new-item-title']")).getText();

              var matcher = pattern.matcher(price);
              if (matcher.find()) {
                var priceAsInt = Integer.valueOf(matcher.group(0));
                return Map.entry(title, priceAsInt);
              }
              return null;
            })
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }

  public void getCourseInfoByPrice(String minOrMax) {

    if (minOrMax.toLowerCase().contains("min")) {
      getCourseInfoWithMinPrice();
    } else if (minOrMax.toLowerCase().contains("max")) {
      getCourseInfoWithMaxPrice();
    } else {
      throw new NoSuchElementException();
    }
  }

  private void getCourseInfoWithMaxPrice() {

    getAllPricesInfo()
        .stream()
        .max(Comparator.comparingInt(Map.Entry::getValue))
        .ifPresent(maxEntry -> {
          System.out.printf("Course with highest price: %s %s ₽", maxEntry.getKey(), maxEntry.getValue());
        });
  }

  private void getCourseInfoWithMinPrice() {

    getAllPricesInfo()
        .stream()
        .min(Comparator.comparingInt(Map.Entry::getValue))
        .ifPresent(minEntry -> {
          System.out.printf("%nCourse with lowest price: %s %s ₽%n", minEntry.getKey(), minEntry.getValue());
        });
  }
}
