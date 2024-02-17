package ru.otus.selenium.pages;

import com.google.inject.Inject;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.otus.selenium.support.DIScoped;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MainPage extends BasePage<MainPage> {

  @Inject
  public MainPage(DIScoped diScoped) {
    super(diScoped);
  }
}
