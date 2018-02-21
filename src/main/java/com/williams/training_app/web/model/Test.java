package com.williams.training_app.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Test {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, message = "Enter the name of the Test!")
    private String name;

    @NotNull
    @Size(min=1, message = "What does this test do?")
    private String description;

    @NotNull
    @Size(min=1, message = "How is the test performed?")
    private String instruction;

    @ManyToMany(mappedBy = "tests")
//    have to have a joincolumn when having a many to one relationship
//    @JoinColumn(name="doctor_id")
    private List<Doctor> doctors;

    public Test(String name, String description, String instruction) {
        this.name = name;
        this.description = description;
        this.instruction = instruction;
    }

    public Test(){ }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
