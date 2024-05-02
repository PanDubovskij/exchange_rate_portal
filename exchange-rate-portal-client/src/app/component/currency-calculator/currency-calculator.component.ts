import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {ExchangeRatesService} from "../../service/exchange-rates.service";
import {ExchangeRate} from "../../model/exchange-rate.model";

@Component({
  selector: 'app-currency-calculator',
  templateUrl: './currency-calculator.component.html',
  styleUrls: ['./currency-calculator.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class CurrencyCalculatorComponent implements OnInit {
  public amount: number = 0;
  public selectedCurrency: string = 'EUR';
  public calculatedAmount: number = 0;
  public exchangeRate: number = 1;
  public exchangeRates: ExchangeRate[] = [];

  constructor(private exchangeRatesService: ExchangeRatesService) {
  }

  ngOnInit() {
    this.exchangeRatesService.getExchangeRates().subscribe(data => {
      this.exchangeRates = data;
    });
  }

  calculate() {
    if (this.selectedCurrency && this.amount) {
      this.exchangeRate = this.exchangeRates.find(rate => rate.ccy2 === this.selectedCurrency)?.amt2 as number;
      this.calculatedAmount = this.amount * this.exchangeRate;
    }
  }
}
