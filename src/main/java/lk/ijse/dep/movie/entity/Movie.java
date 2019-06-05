package lk.ijse.dep.movie.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Movie implements Serializable {
    @Id
    private int id ;
    private String name;

    @OneToMany(mappedBy = "movie")
    private List<RegisterMovie> actorMovies = new ArrayList<>();


    public Movie() {
    }

    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RegisterMovie> getActorMovies() {
        return actorMovies;
    }
}
