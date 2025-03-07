package movie.collection.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="surname")
    @NotBlank(message = "Surname cannot be blank")
    @Length(min=2, max=20,message = "Surname must be between 2 and 20 characters long")
    private String surname;

    @Column(name="name")
    @NotBlank(message = "Name cannot be blank")
    @Length(min=2, max=20,message = "Name must be between 2 and 20 characters long")
    private String name;

    @OneToMany(mappedBy = "actor")
    private Set<Role> roles = new HashSet<>();

    public Actor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
