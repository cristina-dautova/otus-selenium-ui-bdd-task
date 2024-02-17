package ru.otus.selenium.components.popups;

public interface IPopup<T> {

  T beforeEvent();

  T afterEvent();
}
