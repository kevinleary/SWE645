package com.hw3.backend;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Entity
class Student {

  private @Id @GeneratedValue Long id;
  private String firstName;
  private String lastName;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String phone;
  private String email;
  private String date;
  private ArrayList<String> liked;
  private String interested;
  private String recommend;

  Student() {}

  //Constructor
  Student(String firstName, String lastName, String street, String city, String state, 
		  String zip, String phone, String email, String date, ArrayList<String> liked, String interested,
		  String recommend) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.phone = phone;
    this.email = email;
    this.date = date;
    this.liked = liked;
    this.interested = interested;
    this.recommend = recommend;
    
  }

  //getters
  public String getName() {
    return this.firstName + " " + this.lastName;
  }

  public Long getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getStreet() {
	    return this.street;
  }  
 
  public String getCity() {
    return this.city;
  }
  
  public String getState() {
	    return this.state;
  }
  
  public String getZip() {
	    return this.zip;
  }
  
  public String getPhone() {
	    return this.phone;
  }

  public String getEmail() {
	    return this.email;
  }

  public String getDate() {
	    return this.date;
  }

  public ArrayList<String> getLiked() {
	    return this.liked;
  }

  public String getInterested() {
	    return this.interested;
  }
  
  public String getRecommend() {
	    return this.recommend;
}
  
  //setters
  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setName(String name) {
	    String[] parts = name.split(" ");
	    this.firstName = parts[0];
	    this.lastName = parts[1];
  }
 
  public void setStreet(String street) {
	    this.street = street;
  }
 
  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
	    this.state = state;
  }
  
  public void setZip(String zip) {
	    this.zip = zip;
  }
  
  public void setPhone(String phone) {
	    this.phone = phone;
  }
  
  public void setEmail(String email) {
	    this.email = email;
  }
  
  public void setDate(String date) {
	  	//date = Calendar.getInstance(); //maybe
	    this.date = date;
  }
  
  public void setLiked(ArrayList<String> liked) {
	    this.liked = liked;
  }
  
  public void setInterested(String interested) {
	    this.interested = interested;
  }
  
  public void setRecommend(String recommend) {
	    this.recommend = recommend;
  }
  
  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Student))
      return false;
    Student student = (Student) o;
    return Objects.equals(this.id, student.id) && Objects.equals(this.firstName, student.firstName)
        && Objects.equals(this.lastName, student.lastName) && Objects.equals(this.street, student.street)
        && Objects.equals(this.city, student.city) && Objects.equals(this.state, student.state)
        && Objects.equals(this.zip, student.zip) && Objects.equals(this.phone, student.phone)
        && Objects.equals(this.email, student.email) && Objects.equals(this.date, student.date)
        && Objects.equals(this.liked, student.liked) && Objects.equals(this.interested, student.interested)
        && Objects.equals(this.recommend, student.recommend);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.firstName, this.lastName, this.street, this.city, this.state,
    		this.zip, this.phone, this.email, this.date, this.liked, this.interested, this.recommend);
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName
        + '\'' + ", role='" + this.street + '\'' + ", city='" + this.city + '\'' + ", state='" + this.state 
        + '\'' + ", zip='" + this.zip + '\'' + ", phone='" + this.phone + '\'' + ", email='" + this.email 
        + '\'' + ", date='" + this.date + '\'' + ", liked='" + this.liked + '\'' + ", interested='" + this.interested 
        + '\'' + ", recommend='" + this.recommend + '\'' + '}';
  }
}