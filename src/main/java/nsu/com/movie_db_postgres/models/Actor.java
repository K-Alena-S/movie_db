package nsu.com.movie_db_postgres.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstname;

    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastname;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    private LocalDate date_of_birth;

    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Movie> movies;

    public String getFirstname() {
        return firstname;
    }

    public Integer getId(){
        return id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
