import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CentralBankRatesComponent } from './central-bank-rates.component';

describe('CentralBankRatesComponent', () => {
  let component: CentralBankRatesComponent;
  let fixture: ComponentFixture<CentralBankRatesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CentralBankRatesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CentralBankRatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
