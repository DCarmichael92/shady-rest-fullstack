package com.devincarmichael.shadyrest;

import java.math.BigDecimal;

public enum RoomType {
  QUEEN("Queen Bed", new BigDecimal("125.00")),
  KING("King Bed", new BigDecimal("139.00")),
  KING_SUITE("King Bed with Pull-out Couch", new BigDecimal("165.00"));

  private final String description;
  private final BigDecimal baseRate;

  RoomType(String description, BigDecimal baseRate) {
    this.description = description;
    this.baseRate = baseRate;
  }

  public String getDescription() { return description; }
  public BigDecimal getBaseRate() { return baseRate; }
}
