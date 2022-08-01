import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, FormArray } from '@angular/forms';

@Component({
  selector: 'app-profile-editor',
  templateUrl: './profile-editor.component.html',
  styleUrls: ['./profile-editor.component.css']
})
export class ProfileEditorComponent {
  profileForm = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['',  Validators.required],
    address: this.fb.group({
      street: ['',  Validators.required],
      city: ['',  Validators.required],
      state: ['',  Validators.required],
      zip: ['',  Validators.required]
    }),
    phone: ['', Validators.required],
    email: ['', Validators.required],
    date: ['', Validators.required],
    liked: this.fb.array([
    ]),
    interested: this.fb.array([
    ]),
    recommend: [''],
    aliases: this.fb.array([
      this.fb.control('')
    ])
  });

  checkboxes = [ 
    { name: 'Students'},
    { name: 'Location'},
    { name: 'Campus'},
    { name: 'Atmosphere'},
    { name: 'Dorm Rooms'},
    { name: 'Sports'}
  ]

  radio = [
    { name: 'Friends'},
    { name: 'Television'},
    { name: 'Internet'},
    { name: 'Other'}
  ]

  select = [
    { name: 'Likely'},
    { name: 'Very Likely'},
    { name: 'Not Likely'}
  ]

  constructor(private fb: FormBuilder) { }

  onSubmit() {
    console.warn(this.profileForm.value);
  }

  onChangeCheckbox(name: string, isChecked: boolean) {
    const checkboxFormArray = <FormArray>this.profileForm.controls.liked;

    if (isChecked) {
      checkboxFormArray.push(new FormControl(name));
    } else {
      let index = checkboxFormArray.controls.findIndex(x => x.value == name)
      checkboxFormArray.removeAt(index);
    }
  }
  
  onChangeRadio(name: string, isRadioed: boolean) {
    const radioFormArray = <FormArray>this.profileForm.controls.interested;

    if (isRadioed) {
      // radioFormArray.patchValue(new FormControl(name));
      radioFormArray.clear();
      radioFormArray.push(new FormControl(name));
    } else {
      let index = radioFormArray.controls.findIndex(x => x.value == name)
      radioFormArray.removeAt(index);
    }
  }

  updateProfile() {
    this.profileForm.patchValue({
      firstName: 'Nancy',
      address: {
        street: '123 Drew Street'
      }
    });
  }

  get aliases() {
    return this.profileForm.get('aliases') as FormArray;
  }

  // get checkboxes() {
  //   return this.profileForm.get('checkboxes') as FormArray;
  // }

  addAlias() {
    this.aliases.push(this.fb.control(''));
  }

  // addCheckboxes() {
  //   this.checkboxes.push(this.fb.control(''));
  // }

  // get checkboxesFormArray() {
  //   return this.form.controls.orders as FormArray;
  // }

  // private addCheckboxes() {
  //   this.ordersData.forEach(() => this.ordersFormArray.push(new FormControl(false)));
  // }

}
