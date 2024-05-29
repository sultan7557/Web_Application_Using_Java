/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tb2;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ProjectService {

    private final EntityManagerFactory entityManagerFactory;

    public ProjectService() {
        // Assuming you have a persistence unit named "YourPersistenceUnitName"
        this.entityManagerFactory = Persistence.createEntityManagerFactory("my_persistence_unit");
    }

    public List<Project> getAllProjects() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Use TypedQuery to fetch all projects from the database
            TypedQuery<Project> query = entityManager.createQuery("SELECT p FROM Project p", Project.class);
            List<Project> projects = query.getResultList();

            entityManager.getTransaction().commit();

            return projects;
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }

    // Other methods related to ProjectService...

    public Project getProjectById(int projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Use find method to get a project by ID
            Project project = entityManager.find(Project.class, projectId);

            entityManager.getTransaction().commit();

            return project;
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }

    public void saveProject(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Persist the project to the database
            entityManager.persist(project);

            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }

    public void updateProject(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Merge the project to update it in the database
            entityManager.merge(project);

            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }

    public void deleteProject(int projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Find the project by ID
            Project project = entityManager.find(Project.class, projectId);

            // Remove the project from the database
            entityManager.remove(project);

            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }
}
