package com.celin.sitecelin.utils;

import com.celin.sitecelin.entities.users.utils.dto.AddressDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExternalApiHelper {
  public static  <T> T dtoFactory(URL url, Class classType) throws IOException {
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestProperty("accept", "application/json");
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return (T) mapper.readValue(connection.getInputStream(), classType);
  }

  public static URL cepUrl (String zipCode) throws MalformedURLException {
    return new URL("http://viacep.com.br/ws/" + zipCode + "/json/");
  }
}
