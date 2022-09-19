import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TiposContribuyenteComponent } from './tipos-contribuyente.component';

describe('TiposContribuyenteComponent', () => {
  let component: TiposContribuyenteComponent;
  let fixture: ComponentFixture<TiposContribuyenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TiposContribuyenteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TiposContribuyenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
