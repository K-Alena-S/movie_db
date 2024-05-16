package nsu.com.movie_db_postgres.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import nsu.com.movie_db_postgres.models.Actor;


import java.time.LocalDate;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Integer> {

    @Query("SELECT a FROM Actor a where a.date_of_birth >=?1 AND a.date_of_birth <= ?2")
            public List<Actor> filterByDate(LocalDate from, LocalDate to);

    @Query("SELECT a FROM Actor a INNER JOIN Director ON a.date_of_birth")
            public List<Actor> innerByDate();

    @Query("SELECT a FROM Actor a LEFT OUTER JOIN Director ON a.date_of_birth")
    public List<Actor> outerByDate();

}
