package ourbusinessproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String title;
    private String description;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * add a title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the title
     */
    public  String getTitle() {
        return this.title;
    }

    /**
     * add the description
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
}
