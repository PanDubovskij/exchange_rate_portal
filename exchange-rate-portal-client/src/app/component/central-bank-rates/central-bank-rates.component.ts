import { Component, OnInit } from '@angular/core';
import {CommonModule} from "@angular/common";
import {ExchangeRatesService} from "../../service/exchange-rates.service";

@Component({
  selector: 'app-central-bank-rates',
  templateUrl: './central-bank-rates.component.html',
  styleUrls: ['./central-bank-rates.component.css'],
  standalone: true,
  imports: [CommonModule]
})
export class CentralBankRatesComponent implements OnInit {
  public exchangeRates: any[]=[];

  constructor(private exchangeRatesService: ExchangeRatesService) {}

  ngOnInit() {
    this.exchangeRatesService.getAllRates().subscribe(data => {
      this.exchangeRates = data;
    });
  }
}
