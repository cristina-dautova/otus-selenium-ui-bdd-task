package ru.otus.selenium.components;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CourseInfo {

  private LocalDate date;
  private String courseName;
}
