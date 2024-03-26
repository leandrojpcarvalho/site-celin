package com.celin.sitecelin.model;

import java.util.HashMap;

public class Days {
  private static final HashMap<Integer, String> days = new HashMap<>();

  static {
    days.put(1, "Monday");
    days.put(2, "Tuesday");
    days.put(3, "Wednesday");
    days.put(4, "Thursday");
    days.put(5, "Friday");
    days.put(6, "Saturday");
  }

  public static String getDay(String day) {
    if (!days.containsValue(day)) {
      throw new RuntimeException("this day not exists");
    }
    return day;
  }

  public static String getDayByNumber(int dayNumber) {
    if(!days.containsKey(dayNumber)){
      throw new RuntimeException("this day not exists");
    }
    return days.get(dayNumber);
  }
}
