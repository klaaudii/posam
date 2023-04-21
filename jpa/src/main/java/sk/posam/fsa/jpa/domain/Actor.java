package sk.posam.fsa.jpa.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "actor", schema = "public")
@Access(AccessType.FIELD)
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "last_update")
    private Date lastUpdated;

    @OneToMany(mappedBy = "actor")
    private Set<FilmActor> films;

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdated=" + lastUpdated + '\'' +
                ", films=" + films.stream().map(FilmActor::getFilm).map(Film::getTitle).toList() +
                '}';
    }
}