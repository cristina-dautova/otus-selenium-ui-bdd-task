package ru.otus.selenium.components.staticcomponent;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.otus.selenium.annotations.Component;
import ru.otus.selenium.support.DIScoped;
import ru.otus.selenium.utils.BaseUtils;

import java.util.List;


public abstract class AbsBaseComponent extends BaseUtils {

  @Inject
  public AbsBaseComponent(DIScoped scenarioScoped) {
    super(scenarioScoped);
  }

  public List<WebElement> getComponentsEntity() {
    Class clazz = this.getClass();
    if (clazz.isAnnotationPresent(Component.class)) {
      Component path = (Component) clazz.getDeclaredAnnotation(Component.class);
      return path.value().startsWith("/")
          ? driver.findElements(By.xpath(path.value()))
          : driver.findElements(By.cssSelector(path.value()));
    }
    return null;
  }

  {
    assertThat(standardWaiter.isVisible(getComponentsEntity()))
        .as("No component found")
        .isTrue();
  }
}
