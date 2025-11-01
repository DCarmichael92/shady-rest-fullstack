import { Component, OnInit, signal } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators, FormGroup } from '@angular/forms';
import { CurrencyPipe, NgFor, NgIf } from '@angular/common';
import { ApiService } from '../../core/api.service';
import { QuoteResponse, Room } from '../../core/models';

@Component({
  selector: 'app-booking',
  standalone: true,
  imports: [ReactiveFormsModule, NgIf, NgFor, CurrencyPipe],
  templateUrl: './booking.component.html',
})
export class BookingComponent implements OnInit {
  rooms: Room[] = [];
  quote = signal<QuoteResponse | null>(null);
  confirming = signal(false);
  confirmation = signal<string | null>(null);
  form!: FormGroup;

  constructor(private fb: FormBuilder, private api: ApiService) {
    this.form = this.fb.group({
      roomType: ['', Validators.required],
      checkInDate: ['', Validators.required],
      nights: [1, [Validators.required, Validators.min(1), Validators.max(30)]],
      loyaltyMember: [false],
    });
  }

  ngOnInit(): void {
    this.api.getRooms().subscribe(r => this.rooms = r);
  }

  onQuote(): void {
    if (this.form.invalid) return;
    this.api.quote(this.form.value as any).subscribe(q => {
      this.quote.set(q);
      this.confirmation.set(null);
    });
  }

  onBook(): void {
    if (this.form.invalid) return;
    this.confirming.set(true);
    this.api.book(this.form.value as any).subscribe({
      next: (res) => { this.confirmation.set(res.confirmation); this.confirming.set(false); },
      error: () => this.confirming.set(false),
    });
  }
}
