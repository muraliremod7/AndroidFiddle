package com.samplecode.model;

/**
 * Created by Paul on 2013/09/23.
 */
public class Person {

    private Long id;

    private String name;

    private String emailaddress;


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }


    public String getEmailaddress() {
        return this.emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
