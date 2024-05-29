package com.mycompany.tb2;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "project_id") // This column should exist in your 'project' table
    private Employee employee;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "projects")
    private List<Person> persons;

    // Default constructor (needed by JPA)
    public Project() {
    }

    // Constructor without ID (useful for creating new instances)
    public Project(String title) {
        this.title = title;
    }

    // Constructor with ID (useful for retrieving instances from the database)
    public Project(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getter and setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter for persons
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    // Getter and setter for employee
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}