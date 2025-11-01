package com.devincarmichael.shadyrest;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

public record QuoteRequest(
    @NotNull RoomType roomType,
    @NotNull @FutureOrPresent LocalDate checkInDate,
    @Min(1) @Max(30) int nights,
    boolean loyaltyMember
) {}