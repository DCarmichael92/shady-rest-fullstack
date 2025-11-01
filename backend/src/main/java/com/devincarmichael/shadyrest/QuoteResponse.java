package com.devincarmichael.shadyrest;

import java.math.BigDecimal;
import java.util.List;

public record QuoteResponse(List<QuoteLine> lines, BigDecimal subtotal, BigDecimal tax, BigDecimal total) {  }