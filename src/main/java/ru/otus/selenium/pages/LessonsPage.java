package ru.otus.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.otus.selenium.support.DIScoped;

public class LessonsPage extends BasePage<LessonsPage> {

  @Inject
  public LessonsPage(DIScoped diScoped) {
    super(diScoped);
  }

  @FindBy(tagName = "h1")
  private WebElement headerElement;

  @FindBy(xpath = "//div[./h1]//button[./span[text()='Оставить заявку']]")
  private WebElement headerButtonSendRequestButtonElement;

  public LessonsPage pageHeaderShouldBeSameAs(String expectedHeader) {
    assertThat(headerElement.getText())
        .as("Header element comparison")
        .isEqualTo(expectedHeader);
    return this;
  }

  public LessonsPage pageHeaderShouldContain(String expectedHeader) {
    assertThat(headerElement.getText())
        .as("Header element comparison")
        .contains(expectedHeader);
    return this;
  }

  public LessonsPage headerSendRequestButtonShouldBeVisible() {
    assertThat(standardWaiter.isVisible(headerButtonSendRequestButtonElement))
        .as("Visibility of 'Send Request' button")
        .isTrue();
    return this;
  }
}
