package ourbusinessproject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Enterprise {
    @NotNull
    @NotEmpty
    private String name;
    @Size(min=10)
    private String description;
    @NotNull
    @NotEmpty
    private String contactName;
    @NotNull
    @NotEmpty
    @Email
    private String contactEmail;

    public Enterprise(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
