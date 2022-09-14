import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuelOrdersComponent } from './fuel-orders.component';

describe('OrdersComponent', () => {
  let component: FuelOrdersComponent;
  let fixture: ComponentFixture<FuelOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FuelOrdersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FuelOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});