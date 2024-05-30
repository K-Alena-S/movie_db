package nsu.com.movie_db_postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import nsu.com.movie_db_postgres.models.Genre;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
//    trigger_function() {
//
//    }
}
