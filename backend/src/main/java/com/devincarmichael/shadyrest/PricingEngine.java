package com.devincarmichael.shadyrest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

public final class PricingEngine {
  private static final BigDecimal WEEKEND = new BigDecimal("0.10");
  private static final BigDecimal PEAK    = new BigDecimal("0.15");
  private static final BigDecimal MEMBER  = new BigDecimal("0.05");
  private static final BigDecimal TAX     = new BigDecimal("0.06");

  private PricingEngine() {}

  public static BigDecimal nightlyRate(RoomType roomType, LocalDate date, boolean loyalty) {
    BigDecimal rate = roomType.getBaseRate();
    if (isWeekend(date)) rate = rate.multiply(BigDecimal.ONE.add(WEEKEND));
    if (isPeak(date))    rate = rate.multiply(BigDecimal.ONE.add(PEAK));
    if (loyalty)         rate = rate.multiply(BigDecimal.ONE.subtract(MEMBER));
    return rate.setScale(2, RoundingMode.HALF_UP);
  }

  public static BigDecimal tax(BigDecimal sub) {
    return sub.multiply(TAX).setScale(2, RoundingMode.HALF_UP);
  }

  public static BigDecimal total(BigDecimal sub) {
    return sub.add(tax(sub)).setScale(2, RoundingMode.HALF_UP);
  }

  private static boolean isWeekend(LocalDate d) {
    DayOfWeek dow = d.getDayOfWeek();   // <-- corrected
    return dow == DayOfWeek.FRIDAY || dow == DayOfWeek.SATURDAY;
  }

  private static boolean isPeak(LocalDate d) {
    int m = d.getMonthValue();
    return m >= 6 && m <= 8; // Jun–Aug
  }
}
