package sk.posam.fsa.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "film_actor", schema = "public")
@Access(AccessType.FIELD)
public class FilmActor implements Serializable {
    @EmbeddedId
    private FilmActorPK id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name="actor_id")
    private Actor actor;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name="film_id")
    private Film film;

    @Column(name = "last_update")
    private Date lastUpdated;

    public FilmActorPK getId() {
        return id;
    }

    public void setId(FilmActorPK id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
