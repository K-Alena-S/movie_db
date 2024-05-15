package nsu.com.movie_db_postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import nsu.com.movie_db_postgres.models.Director;

public interface DirectorRepository extends JpaRepository<Director,Integer> {
}
