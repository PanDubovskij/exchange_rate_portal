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
  public exchangeRateHistory: ExchangeRate[]=[];
  public selectedCurrency: string='EUR';

  constructor(private exchangeRatesService: ExchangeRatesService) {}

  ngOnInit() {
    // Initially, no currency is selected, so no history is displayed
    this.exchangeRatesService.getAllRates().subscribe(data => {
      console.log(data)
      this.exchangeRateHistory = data;
    });
  }

  onSelectCurrency(currency: string) {
    this.selectedCurrency = currency;
    this.exchangeRatesService.getAllRates().subscribe(data => {
      console.log(data)
      this.exchangeRateHistory = data;
    });
  }
}
