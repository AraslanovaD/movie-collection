package movie.collection.dto;

import movie.collection.entity.Genre;

public class GenreDTO {
    private int id;
    private String title;

    public GenreDTO() {}

    public GenreDTO (Genre genre){
        this.id = genre.getId();
        this.title = genre.getTitle();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
