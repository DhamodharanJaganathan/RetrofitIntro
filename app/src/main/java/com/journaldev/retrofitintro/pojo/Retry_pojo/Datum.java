package com.journaldev.retrofitintro.pojo.Retry_pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Datum implements Serializable {

  private final static long serialVersionUID = -7178258119414668147L;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("year")
  @Expose
  private Integer year;
  @SerializedName("color")
  @Expose
  private String color;
  @SerializedName("pantone_value")
  @Expose
  private String pantoneValue;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getPantoneValue() {
    return pantoneValue;
  }

  public void setPantoneValue(String pantoneValue) {
    this.pantoneValue = pantoneValue;
  }

}
