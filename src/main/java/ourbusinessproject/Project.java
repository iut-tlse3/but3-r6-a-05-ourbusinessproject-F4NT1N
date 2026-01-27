package ourbusinessproject;

import jakarta.validation.constraints.NotBlank;

public class Project {
    @NotBlank
    private String title;
    private String description;

    public Project() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public  String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
