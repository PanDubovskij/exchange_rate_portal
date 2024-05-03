import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ExchangeRatesService {
  constructor(private http: HttpClient) {
  }

  getExchangeRates(): Observable<any> {
    let apiUrl = `${environment.host}/api/v0.0.2/exchange-rates-portal/current-rates`;
    return this.http.get(apiUrl);
  }

  getExchangeRateHistory(currency: string): Observable<any> {
    let apiUrl = `${environment.host}/api/v0.0.2/exchange-rates-portal/rates-for-currency?currencyCode=${currency}`;
    return this.http.get(apiUrl, {params: {currency: currency}});
  }

  getAllRates(): Observable<any> {
    let apiUrl = '${environment.host}/api/v0.0.2/exchange-rates-portal/all-rates';
    return this.http.get(apiUrl);
  }
}
