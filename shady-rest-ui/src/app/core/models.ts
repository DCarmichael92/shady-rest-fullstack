export interface Room {
    code: string;
    description: string;
    baseRate: number;   
}

export type RoomType = 'QUEEN' | 'KING' | 'KING_SUITE';

export interface QuoteRequest {
    roomType: RoomType;
    checkInDate: string;
    nights: number;
    loyaltyMember: boolean;
}

export interface QuoteLine {
    date: string;
    nightly: number | string;
}

export interface QuoteResponse {
    lines: QuoteLine[];
    subtotal: number | string;
    tax: number | string;
    total: number | string;
}