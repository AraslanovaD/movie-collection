package movie.collection.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_movie")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "id_actor")
    private Actor actor;

    @Column(name = "role")
    @NotBlank(message = "Role cannot be blank")
    @Length(min=2, max=40,message = "Role must be between 2 and 40 characters long")
    private String role;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", movie=" + movie +
                ", actor=" + actor +
                ", role='" + role + '\'' +
                '}';
    }
}
