package movie.collection.dto;

import movie.collection.entity.Role;

public class RoleDTO {
    private int id;
    private MovieDTO movieDTO;
    private ActorDTO actorDTO;
    private String role;

    public RoleDTO() {
    }

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.movieDTO = new MovieDTO(role.getMovie());
        this.actorDTO = new ActorDTO(role.getActor());
        this.role = role.getRole();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MovieDTO getMovieDTO() {
        return movieDTO;
    }

    public void setMovieDTO(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
    }

    public ActorDTO getActorDTO() {
        return actorDTO;
    }

    public void setActorDTO(ActorDTO actorDTO) {
        this.actorDTO = actorDTO;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
