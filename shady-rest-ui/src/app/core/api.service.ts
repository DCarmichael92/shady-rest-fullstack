import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room, QuoteRequest, QuoteResponse } from './models';

@Injectable({ providedIn: 'root' })
export class ApiService {
  constructor(private http: HttpClient) {}

  getRooms(): Observable<Room[]> {
    return this.http.get<Room[]>('/api/rooms');
  }

  quote(req: QuoteRequest): Observable<QuoteResponse> {
    return this.http.post<QuoteResponse>('/api/quote', req);
  }

  book(req: QuoteRequest): Observable<{ confirmation: string; status: string }> {
    return this.http.post<{ confirmation: string; status: string }>('/api/bookings', req);
  }
}
