import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExchangeRatesService {
  private apiUrl = 'http://localhost:8080/api/v0.0.2/exchange-rates-portal/all-rates';

  constructor(private http: HttpClient) {}

  getExchangeRates(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getExchangeRateHistory(currency: string): Observable<any> {
    return this.http.get(this.apiUrl, { params: { currency: currency } });
  }

  getAllRates(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
}
