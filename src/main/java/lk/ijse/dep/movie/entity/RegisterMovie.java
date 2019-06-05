package lk.ijse.dep.movie.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class RegisterMovie implements Serializable {
    @EmbeddedId
    private RegisterMoviePK registerMoviePK;
    @ManyToOne
    @JoinColumn(name = "actor_Id", referencedColumnName = "id", insertable = false, updatable = false)
    private Actor actor;
    @ManyToOne
    @JoinColumn(name = "movie_Id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movie movie;
    private String role;
    public RegisterMovie() {
    }

    public RegisterMovie(RegisterMoviePK registerMoviePK, Actor actor, Movie movie,String role) {
        this.registerMoviePK = registerMoviePK;
        this.actor = actor;
        this.movie = movie;
        this.role=role;
    }
    public RegisterMovie(int actor, int movie,String role) {

        this.registerMoviePK = new RegisterMoviePK(actor,movie);
        this.role=role;
    }

    public RegisterMoviePK getRegisterMoviePK() {
        return registerMoviePK;
    }

    public void setRegisterMoviePK(RegisterMoviePK registerMoviePK) {
        this.registerMoviePK = registerMoviePK;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
