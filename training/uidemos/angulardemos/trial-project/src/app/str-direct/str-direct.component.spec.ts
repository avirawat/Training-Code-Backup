import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StrDirectComponent } from './str-direct.component';

describe('StrDirectComponent', () => {
  let component: StrDirectComponent;
  let fixture: ComponentFixture<StrDirectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StrDirectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StrDirectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
