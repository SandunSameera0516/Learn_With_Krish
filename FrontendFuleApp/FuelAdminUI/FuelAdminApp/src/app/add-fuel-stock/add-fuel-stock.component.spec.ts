import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFuelStockComponent } from './add-fuel-stock.component';

describe('AddStockComponent', () => {
  let component: AddFuelStockComponent;
  let fixture: ComponentFixture<AddFuelStockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFuelStockComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddFuelStockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});