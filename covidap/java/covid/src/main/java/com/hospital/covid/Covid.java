package com.hospital.covid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Covid {

    @Id
    @Column(name="id")
    private String id = "";

    @Column(name="name")
    private String name = "";

    @Column(name="address")
    private String address = "";

    @Column(name="dob")
    private String dob = "";

    @Column(name="age")
    private String age = "";

    @Column(name="gender")
    private String gender = "";

    @Column(name="phone")
    private String phone = "";

    @Column(name="covidstatus")
    private String covidstatus = "";

    @Column(name="admissionstatus")
    private String admissionstatus = "";

public Covid()
{

}
    public Covid(String id, String name, String address, String dob, String age, String gender, String phone, String covidstatus, String admissionstatus){
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.age = age;
        this.gender =gender;
        this.phone = phone;
        this.covidstatus = covidstatus;
        this.admissionstatus = admissionstatus;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getDob(){
        return dob;
    }

    public String getAge(){
        return age;
    }

    public String getGender() {return gender;}

    public String getPhone(){
        return phone;
    }

    public String getCovidstatus() {return covidstatus;}

    public String getAdmissionstatus() {return admissionstatus;}


}

