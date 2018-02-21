package com.williams.training_app.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1,max=30, message="Please enter a doctors name!")
    private String name;

    @NotNull
    @Size(min=1,max=30, message = "Please enter the doctors clinic!")
    private String clinic;

    @NotNull
    @Size(min=1, message = "Please enter the work up for the doctor!")
    private String description;

    @ManyToMany
//            (targetEntity = Test.class, mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Test> tests = new ArrayList<>();

    public List<Test> getTests() { return tests; }


    public Doctor(){}

    public Doctor(String name, String clinic, String description){
        this.name = name;
        this.clinic = clinic;
        this.description = description;

    }

    public void addItem(Test item){ tests.add(item); }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
