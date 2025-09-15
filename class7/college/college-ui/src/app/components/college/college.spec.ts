import { ComponentFixture, TestBed } from '@angular/core/testing';

import { College } from './college';

describe('College', () => {
  let component: College;
  let fixture: ComponentFixture<College>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [College]
    })
    .compileComponents();

    fixture = TestBed.createComponent(College);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
