package ru.otus.selenium.components.popups;

import com.google.inject.Inject;
import ru.otus.selenium.support.DIScoped;
import ru.otus.selenium.utils.BaseUtils;

public abstract class AbsBasePopup<T> extends BaseUtils implements IPopup<T> {

  @Inject
  public AbsBasePopup(DIScoped scenarioScoped) {
    super(scenarioScoped);
  }
}
