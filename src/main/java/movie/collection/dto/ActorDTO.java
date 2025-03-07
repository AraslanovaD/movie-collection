package movie.collection.dto;

import movie.collection.entity.Actor;

public class ActorDTO {
    private int id;
    private String surname;
    private String name;

    public ActorDTO() {
    }

    public ActorDTO(Actor actor) {
        this.id = actor.getId();
        this.surname = actor.getSurname();
        this.name = actor.getName();
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
}
