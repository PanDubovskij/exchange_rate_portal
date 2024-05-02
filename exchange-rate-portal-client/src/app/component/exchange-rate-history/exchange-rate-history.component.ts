import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {ExchangeRatesService} from "../../service/exchange-rates.service";
import {FormsModule} from "@angular/forms";
import {ExchangeRate} from "../../model/exchange-rate.model";

@Component({
  selector: 'app-exchange-rate-history',
  templateUrl: './exchange-rate-history.component.html',
  styleUrls: ['./exchange-rate-history.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class ExchangeRateHistoryComponent implements OnInit {
  public currencies: string[] = [];
  public rates: ExchangeRate[] = [];
  public exchangeRateHistory: ExchangeRate[] = [];
  public selectedCurrency: string = 'EUR';

  constructor(private exchangeRatesService: ExchangeRatesService) {
  }

  ngOnInit() {
    this.exchangeRatesService.getExchangeRates().subscribe(data => {
      this.rates = data
      for (let rate of this.rates) {
        this.currencies.push(rate.ccy2)
      }
    });
  }

  onSelectCurrency(currency: string) {
    this.selectedCurrency = currency;
    this.exchangeRatesService.getExchangeRateHistory(this.selectedCurrency).subscribe(data => {
      this.exchangeRateHistory = data;
    });
  }
}
