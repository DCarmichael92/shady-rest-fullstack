package com.devincarmichael.shadyrest;

import java.math.BigDecimal;
import java.time.LocalDate;

public record QuoteLine(LocalDate date, BigDecimal nightly) { }
