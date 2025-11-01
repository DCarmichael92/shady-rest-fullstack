package com.devincarmichael.shadyrest;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "bookings")
public class Booking {
  @Id @GeneratedValue
  private UUID id;

  @Enumerated(EnumType.STRING)
  @Column(nullable=false)
  private RoomType roomType;

  @Column(nullable=false)
  private LocalDate checkInDate;

  @Column(nullable=false)
  private int nights;

  @Column(nullable=false)
  private boolean loyaltyMember;

  @Column(nullable=false)
  private OffsetDateTime createdAt = OffsetDateTime.now();

  // getters/setters
  public UUID getId(){return id;}
  public RoomType getRoomType(){return roomType;}
  public void setRoomType(RoomType r){this.roomType=r;}
  public LocalDate getCheckInDate(){return checkInDate;}
  public void setCheckInDate(LocalDate d){this.checkInDate=d;}
  public int getNights(){return nights;}
  public void setNights(int n){this.nights=n;}
  public boolean isLoyaltyMember(){return loyaltyMember;}
  public void setLoyaltyMember(boolean l){this.loyaltyMember=l;}
  public OffsetDateTime getCreatedAt(){return createdAt;}
  public void setCreatedAt(OffsetDateTime t){this.createdAt=t;}
}
