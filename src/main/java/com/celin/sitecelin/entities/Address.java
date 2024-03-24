package com.celin.sitecelin.entities;

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

  public Address(String zip) throws IOException {
    setZipCode(zip);
  }
  public static RecordAddress zipCodeURL(String ZIPCode) throws IOException {
    URL url = new URL("http://viacep.com.br/ws/" + ZIPCode + "/json/");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestProperty("accept", "application/json");
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return mapper.readValue(connection.getInputStream(), RecordAddress.class);
  }

  private void setZipCode(String zip) throws IOException {
    RecordAddress recordAddress = zipCodeURL(zip);
    address = recordAddress.address();
    zipCode = recordAddress.ZIP();
    city = recordAddress.city();
    state = recordAddress.state();
  }


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
    this.number = number;
  }
}
