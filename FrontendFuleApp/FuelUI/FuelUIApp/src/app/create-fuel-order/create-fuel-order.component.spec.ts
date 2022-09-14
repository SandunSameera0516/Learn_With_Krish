import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFuelOrderComponent } from './create-fuel-order.component';

describe('CreateFuelOrderComponent', () => {
  let component: CreateFuelOrderComponent;
  let fixture: ComponentFixture<CreateFuelOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateFuelOrderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateFuelOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
