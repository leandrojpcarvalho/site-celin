package com.celin.sitecelin.entities.users.utils;

import java.util.LinkedHashMap;
import java.util.UUID;

public class Phone {
  public static final LinkedHashMap<Integer, String> dddList = new LinkedHashMap<>();

  static {
    dddList.put(11, "São Paulo (SP)");
    dddList.put(12, "São José dos Campos (SP) e Vale do Paraíba (SP)");
    dddList.put(13, "Baixada Santista (SP)");
  }
  private Integer number;
  private int ddd;
  private String local;

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public int getDdd() {
    return ddd;
  }

  public void setDdd(int ddd) {
    if (dddList.containsKey(ddd)) {
      this.ddd = ddd;
      this.local = dddList.get(ddd);
    } else {
      throw new IllegalArgumentException("This ddd "+ ddd+ " does not exist");
    }
  }

  public String getLocal() {
    return local;
  }

  @Override
  public String toString() {
    return ddd + " " + number;
  }
}
