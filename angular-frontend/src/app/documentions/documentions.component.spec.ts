import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentionsComponent } from './documentions.component';

describe('DocumentionsComponent', () => {
  let component: DocumentionsComponent;
  let fixture: ComponentFixture<DocumentionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
