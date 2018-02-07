package com.williams.training_app.web.model.forms;

import com.williams.training_app.web.model.Doctor;
import com.williams.training_app.web.model.Test;

import javax.validation.constraints.NotNull;

public class AddTestItemForm {

    @NotNull
    private int doctorId;

    @NotNull
    private int testId;

    private Iterable<Test> tests;

    private Doctor doctor;

    public Doctor getDoctor() { return doctor; }

    public int getDoctorId() { return doctorId; }

    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public int getTestId() { return testId; }

    public void setTestId(int testId) { this.testId = testId; }

    public AddTestItemForm(Doctor doctor, Iterable<Test> tests){
        this.tests = tests;
        this.doctor = doctor; }

    public AddTestItemForm(){ }

    public Iterable<Test> getTests() { return tests; }

    public void setTests(Iterable<Test> tests) { this.tests = tests; }


    public void setDoctor(Doctor doctor) {this.doctor = doctor; }
}
