package lk.ijse.dep.movie.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RegisterMoviePK implements Serializable {
    @Column(name ="actor_id" )
    private int actorId;
    @Column(name = "movie_id")
    private int movieId;


    public RegisterMoviePK() {
    }

    public RegisterMoviePK(int actorId, int movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    @Override
    public String toString() {
        return "RegisterMoviePK{" +
                "actorId=" + actorId +
                ", movieId=" + movieId +
                '}';
    }

}
