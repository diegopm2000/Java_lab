package com.collections.beans;

import java.util.List;

public class Country {

  private String name;
  private List<City> cities;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<City> getCities() {
    return this.cities;
  }

  public void setCities(List<City> cities) {
    this.cities = cities;
  }
  
}