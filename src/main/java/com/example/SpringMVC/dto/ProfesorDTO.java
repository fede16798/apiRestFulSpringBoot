package com.example.SpringMVC.dto;

import java.io.Serializable;

public class ProfesorDTO implements Serializable {
    private Long id;
    private String fullname;
    private String name;
    private String lastname;

    public ProfesorDTO() {}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Long getId() {
        return id;
    }
    public String getFullname() {
        return fullname;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "ProfesorDTO{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
