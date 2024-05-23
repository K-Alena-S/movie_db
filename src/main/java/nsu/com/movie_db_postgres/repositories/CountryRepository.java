package nsu.com.movie_db_postgres.repositories;

import nsu.com.movie_db_postgres.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}
