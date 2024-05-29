/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tb2;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "designation")
    private String designation;

    @OneToMany(mappedBy = "employee") // Updated mappedBy attribute to match the field in the Project entity
    private List<Project> projects;

/*     @OneToMany(mappedBy = "persons") // Updated mappedBy attribute to match the field in the Project entity
    private List<Project> projects; */

    // Constructors, getters, setters...

    // Getter and setter for projects
    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
