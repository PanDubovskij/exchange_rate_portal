import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {CurrencyCalculatorComponent} from "../currency-calculator/currency-calculator.component";
import {CentralBankRatesComponent} from "../central-bank-rates/central-bank-rates.component";
import {ExchangeRateHistoryComponent} from "../exchange-rate-history/exchange-rate-history.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CurrencyCalculatorComponent, CentralBankRatesComponent, ExchangeRateHistoryComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'exchange-rate-portal-client';
}
