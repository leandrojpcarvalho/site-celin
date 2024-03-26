package com.celin.sitecelin.entities.users.utils;

import com.celin.sitecelin.entities.exceptions.IllegalUserField;
import com.celin.sitecelin.entities.users.utils.dto.AddressDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Address {
  private String address;
  private String zipCode;
  private String city;
  private String state;
  private String complement;
  private Integer number;

  public String getAddress() {
    return address;
  }
  public String getZipCode() {
    return zipCode;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    if(number <= 0) {
      throw new IllegalUserField("the number must be greater than 0");
    }
    this.number = number;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
    this.state = state;
  }
}
