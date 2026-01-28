package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @Size(min=10)
    private String description;
    @NotBlank
    private String contactName;
    @NotBlank @Email
    private String contactEmail;
    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * add a name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * add a description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * add a contactName
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * @return the contactName
     */
    public String getContactName() {
        return this.contactName;
    }

    /**
     * add a contactEmail
     * @param contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * @return the contactEmail
     */
    public String getContactEmail() {
        return this.contactEmail;
    }


    /**
     * add the project to the list of linked projects
     * @param project
     */
    public void addProject(Project project) {
        if (this.projects == null) {
            this.projects = new ArrayList<Project>();
        }
        this.projects.add(project);
    }


    /**
     * @return the list of projects linked to the enterprise
     */
    public Collection<Project> getProjects() {
        return this.projects;
    }
}
