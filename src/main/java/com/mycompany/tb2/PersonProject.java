/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tb2;

import jakarta.persistence.*;

@Entity
@Table(name = "person_project")
public class PersonProject {

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // Default constructor (needed by JPA)
    public PersonProject() {
    }

    // Constructor with parameters
    public PersonProject(Person person, Project project) {
        this.person = person;
        this.project = project;
    }

    // Getters and setters
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
