package com.devincarmichael.shadyrest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200") // dev only; remove when serving Angular from Spring
public class BookingController {

  @GetMapping("/rooms")
  public List<Room> rooms() {
    // Map enum values to DTOs with explicit fields
    return Arrays.stream(RoomType.values())
        .map(rt -> new Room(rt.name(), rt.getDescription(), rt.getBaseRate()))
        .toList(); // Java 16+; use Collectors.toList() if on older Java
  }

  @PostMapping("/quote")
  public QuoteResponse quote(@Valid @RequestBody QuoteRequest req) {
    var lines = new ArrayList<QuoteLine>();
    for (int i = 0; i < req.nights(); i++) {
      var date = req.checkInDate().plusDays(i);
      var nightly = PricingEngine.nightlyRate(req.roomType(), date, req.loyaltyMember());
      lines.add(new QuoteLine(date, nightly));
    }
    BigDecimal subtotal = lines.stream()
        .map(QuoteLine::nightly)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    BigDecimal tax = PricingEngine.tax(subtotal);
    BigDecimal total = PricingEngine.total(subtotal);
    return new QuoteResponse(lines, subtotal, tax, total);
  }

  @PostMapping("/bookings")
public Map<String, Object> book(@Valid @RequestBody QuoteRequest req) {
  var saved = bookingService.createFrom(req);
  return Map.of("confirmation", saved.getId().toString(), "status", "BOOKED");
}
private final BookingService bookingService;
public BookingController(BookingService bookingService){ this.bookingService = bookingService; }

}
