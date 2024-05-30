package nsu.com.movie_db_postgres.repositories;

import nsu.com.movie_db_postgres.models.Director;
import nsu.com.movie_db_postgres.models.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudioRepository extends JpaRepository<Studio,Integer> {

//    @Query ("WITH RECURSIVE studio_tree AS (" +
//    "SELECT * FROM Studio WHERE sait IS NULL" +
//    "UNION ALL" +
//    "SELECT s.* FROM Studio s JOIN studio_tree t ON s.sait = t.id)" +
//    "SELECT * FROM studio_tree")
//    public List<Director> sortByDate();
}
