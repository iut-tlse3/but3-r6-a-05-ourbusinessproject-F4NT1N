package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EnterpriseProjectService {
    private final EntityManager entityManager;

    /**
     * Create a new enterprise project service
     * @param entityManager
     */
    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     * Create and return a new project in the entitymanager
     * @param title of the project
     * @param description of the project
     * @param enterprise linked to the project
     * @return the new project
     */
    public Project newProject(String title, String description,  Enterprise enterprise) {
        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        project.setEnterprise(enterprise);
        entityManager.persist(project);
        entityManager.flush();
        enterprise.addProject(project);
        return project;
    }

    /**
     * Create and return a new enterprise
     * @param name of the enterprise
     * @param description of the enterprise
     * @param contactName of the enterprise
     * @param contactEmail of the enterprise
     * @return the new enterprise
     */
    public Enterprise newEnterprise(String name, String description, String contactName, String contactEmail){
        Enterprise enterprise = new Enterprise();
        enterprise.setName(name);
        enterprise.setDescription(description);
        enterprise.setContactName(contactName);
        enterprise.setContactEmail(contactEmail);
        entityManager.persist(enterprise);
        entityManager.flush();
        return enterprise;
    }

    /**
     * find and return a project by ID
     * @param projectId
     * @return the project found or throw an exception
     */
    public Project findProjectById(Long projectId){
        return entityManager.find(Project.class, projectId);
    }

    /**
     * find and return an enterprise by ID
     * @param enterpriseId
     * @return the enterprise found or throw an exception
     */
    public Enterprise findEnterpriseById(Long enterpriseId){
        return entityManager.find(Enterprise.class, enterpriseId);
    }


    /**
     * find all projects ordered by title
     * @return The list of all project sorted by title
     */
    public List<Project> findAllProjects() {
        String query = "SELECT p FROM Project p ORDER BY p.title";
        TypedQuery<Project> queryObj = entityManager.createQuery(query, Project.class);
        return queryObj.getResultList();
    }
}
