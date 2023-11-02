import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadboxComponent } from './uploadbox.component';

describe('UploadboxComponent', () => {
  let component: UploadboxComponent;
  let fixture: ComponentFixture<UploadboxComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UploadboxComponent]
    });
    fixture = TestBed.createComponent(UploadboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
