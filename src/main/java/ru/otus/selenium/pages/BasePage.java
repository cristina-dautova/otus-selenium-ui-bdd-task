package ru.otus.selenium.pages;

import ru.otus.selenium.annotations.Path;
import ru.otus.selenium.support.DIScoped;
import ru.otus.selenium.utils.BaseUtils;

public abstract class BasePage<T> extends BaseUtils {

  private String baseUrl = APPLICATION_CONFIG.baseUrl();

  public BasePage(DIScoped scenarioScoped) {
    super(scenarioScoped);
  }

  private String getPath() {
    Class clazz = this.getClass();
    if (clazz.isAnnotationPresent(Path.class)) {
      Path path = (Path) clazz.getDeclaredAnnotation(Path.class);
      return path.value().endsWith("/") ? path.value() : path.value() + "/";
    }
    return "";
  }

  public T open() {
    driver.get(baseUrl + getPath());
    return (T) this;
  }
}
