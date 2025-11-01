package com.devincarmichael.shadyrest;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
  private final BookingRepository repo;
  public BookingService(BookingRepository repo){ this.repo = repo; }

  public Booking createFrom(QuoteRequest req){
    var b = new Booking();
    b.setRoomType(req.roomType());
    b.setCheckInDate(req.checkInDate());
    b.setNights(req.nights());
    b.setLoyaltyMember(req.loyaltyMember());
    return repo.save(b);
  }
}
