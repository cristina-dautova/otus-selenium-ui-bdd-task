package ru.otus.selenium;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:application.properties"})
public interface ApplicationConfig extends Config {

  @Key("baseUrl")
  String baseUrl();

  @Key("browser")
  String browser();
}
