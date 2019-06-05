package lk.ijse.dep.movie.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor implements Serializable {
    @Id
    private int id;
    private String name;
    private String age;

    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.PERSIST})
    @OneToMany(mappedBy = "actor")
    private List<RegisterMovie> actorMovies = new ArrayList<>();


    public Actor() {

    }

    public Actor(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<RegisterMovie> getActorMovies() {
        return actorMovies;
    }
}
