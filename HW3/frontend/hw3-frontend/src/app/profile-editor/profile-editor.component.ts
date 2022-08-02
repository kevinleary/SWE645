import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl, FormBuilder, Validators, FormArray } from '@angular/forms';
import { StudentService } from '../student-service.service';
import { Student } from '../student';

@Component({
  selector: 'app-profile-editor',
  templateUrl: './profile-editor.component.html',
  styleUrls: ['./profile-editor.component.css']
})
export class ProfileEditorComponent {

  student: Student;

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
    interested: [''],
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

  constructor(private fb: FormBuilder, 
    private route: ActivatedRoute, 
    private router: Router, 
    private studentService: StudentService) { 
      this.student = new Student();
  }
  
  onSubmit() {
    console.warn(this.profileForm.value);
    // this.studentService.save(this.profileForm).subscribe(result => this.gotoStudentList());
    // let student = {...this.profileForm.value}
    // this.student.id = Math.floor(Math.random() * 1000000) + 1; //random ids
    this.student.firstName = this.profileForm.value.firstName
    this.student.lastName = this.profileForm.value.lastName
    this.student.street = this.profileForm.value.address.street
    this.student.city = this.profileForm.value.address.city
    this.student.state = this.profileForm.value.address.state
    this.student.zip = this.profileForm.value.address.zip
    this.student.phone = this.profileForm.value.phone
    this.student.email = this.profileForm.value.email
    this.student.date = this.profileForm.value.date
    this.student.liked = this.profileForm.value.liked
    this.student.interested = this.profileForm.value.interested
    this.student.recommend = this.profileForm.value.recommend
    // student.lastName
    this.studentService.save(this.student).subscribe(result => this.gotoStudentList());
    // console.warn(this.student.id);
    console.warn(this.student.street)
    console.warn(this.student.liked)
  }

  gotoStudentList() {
    this.router.navigate(['/students']);
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
    const radioForm = <FormControl>this.profileForm.controls.interested;

    if (isRadioed) {
      radioForm.setValue(new FormControl(name).value);
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
