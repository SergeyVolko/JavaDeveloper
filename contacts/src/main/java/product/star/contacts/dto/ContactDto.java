package product.star.contacts.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import product.star.contacts.models.Contact;

public class ContactDto {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    @NotBlank(message = "name не должен быть пустым")
    private String name;

    @JsonProperty("surname")
    @NotBlank(message = "surname не должен быть пустым")
    private String surname;

    @Email(message = "Некорректный адрес электронной почты")
    @NotBlank(message = "Email не должен быть пустым")
    @JsonProperty("email")
    private String email;

    public ContactDto() {
    }

    public ContactDto(Contact contact) {
        this.id = contact.getId();
        this.name = contact.getName();
        this.surname = contact.getSurname();
        this.email = contact.getEmail();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
