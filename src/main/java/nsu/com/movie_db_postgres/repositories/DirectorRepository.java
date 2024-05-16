package nsu.com.movie_db_postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import nsu.com.movie_db_postgres.models.Director;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director,Integer> {

    @Query("SELECT d.firstname, COUNT(d.age) AS ModelsCount\n" +
            "    FROM Director d\n" +
            "    WHERE d.age > 30\n" +
            "    GROUP BY d.firstname\n" +
            "    ORDER BY ModelsCount DESC")
            public List<Director> sortByDate();



}
