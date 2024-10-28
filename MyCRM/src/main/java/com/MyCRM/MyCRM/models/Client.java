package com.MyCRM.MyCRM.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column
    private String companyName;

    @Column
    private String contactName; //Əlaqə şəxsinin adı

    @Column
    private Long phoneNumberLong;

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public void setContactName(String contactName){
        this.contactName = contactName;
    }
    
    public void setRole(Long phonLong){
        this.phoneNumberLong = phonLong;
    }

    public Integer getId(){
        return this.Id;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public String getContactName(){
        return this.contactName;
    }

    public Long getPhoneNumber(){
        return this.phoneNumberLong;
    }
}
