//package net.boybacks.tempbanapi;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public enum TimeUnits {
//
//  SECOND("Second(s)", 1, "s"),
//  MINUTE("Minute(s)", 60, "m"),
//  HOUR("Hour(s)", 60*60, "h"),
//  DAY("Day(s)", 24*60*60, "d"),
//  WEEK("Week(s)", 7*24*60*60, "w"),
//  MONTH("Month(s)", 4*7*24*60*60, "mo"),
//  YEAR("Year(s)", 12*4*7*24*60*60, "y");
//
//  private String name;
//  private int toSecond;
//  private String shortcut;
//
//  TimeUnits(String name, int toSecond, String shortcut) {
//    this.name = name;
//    this.toSecond = toSecond;
//    this.shortcut = shortcut;
//  }
//
//  public int getToSecond() {
//    return toSecond;
//  }
//
//  public String getName() {
//    return name;
//  }
//
//  public String getShortcut() {
//    return shortcut;
//  }
//
//  public static List<String> getUnitsAsString() {
//    List<String> units = new ArrayList<String>();
//    for(TimeUnits unit : TimeUnits.values()) {
//      units.add(unit.getShortcut().toLowerCase());
//    }
//    return units;
//  }
//
//  public static TimeUnits getUnit(String unit) {
//    for(TimeUnits units : TimeUnits.values()) {
//      if(units.getShortcut().toLowerCase().equals(unit.toLowerCase())) {
//        return units;
//      }
//    }
//    return null;
//  }
//}
