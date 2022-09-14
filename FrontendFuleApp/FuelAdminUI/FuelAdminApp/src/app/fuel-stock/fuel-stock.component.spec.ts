import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelStockComponent } from './fuel-stock.component';

describe('FuelStockComponent', () => {
  let component: FuelStockComponent;
  let fixture: ComponentFixture<FuelStockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FuelStockComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FuelStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});