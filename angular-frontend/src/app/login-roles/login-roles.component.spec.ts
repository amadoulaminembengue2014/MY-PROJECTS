import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginRolesComponent } from './login-roles.component';

describe('LoginRolesComponent', () => {
  let component: LoginRolesComponent;
  let fixture: ComponentFixture<LoginRolesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginRolesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginRolesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
