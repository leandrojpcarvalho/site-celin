package com.celin.sitecelin.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Time {
  public static final HashMap<Integer, String[]> startAndEnd = new HashMap<>();

  static {
    startAndEnd.put(1, new String[]{"08:00", "10:00"});
    startAndEnd.put(2, new String[]{"10:00", "12:00"});
    startAndEnd.put(3, new String[]{"14:00", "16:00"});
    startAndEnd.put(3, new String[]{"16:00", "18:00"});
    startAndEnd.put(4, new String[]{"18:30", "20:30"});
  };

  public static List<String[]> getTimeStartAt(String number) {
    return startAndEnd.values().stream()
          .filter(strings -> strings[0].equals(number))
          .collect(Collectors.toList());
  }

  public static List<String[]> getTimeEndsAt(String number) {
    return startAndEnd.values().stream()
          .filter(strings -> strings[1].equals(number))
          .collect(Collectors.toList());
  }
}
