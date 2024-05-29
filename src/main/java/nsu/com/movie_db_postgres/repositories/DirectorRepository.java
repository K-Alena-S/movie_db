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

    @Query("SELECT COUNT(d.age), d.firstname, d.lastname FROM Director d " +
            "GROUP BY d.firstname, d.lastname HAVING COUNT(d.age) > 50")
            public List<Director> having50();

    @Query("SELECT d.firstname AS director_firstname, a.firstname AS actor_firstname" +
            " FROM Director d INNER JOIN Actor a ON d.id = a.id")
            public List<Director> inner_name_one();

    @Query("SELECT d.firstname AS director_firstname, a.firstname AS actor_firstname " +
            "FROM Director d LEFT OUTER JOIN Actor a ON d.id = a.id\n")
            public List<Director> outer_name_one();

    @Query ("SELECT d.firstname, d.lastname, d.age FROM Director d\n" +
            "WHERE d.age < (SELECT AVG(d.age) FROM Director)")
    public List<Director> name_age();

//    @Query("SELECT * FROM Director d WHERE d.age IN (SELECT MAX(age) FROM Director GROUP BY firstname")
//            public List<Director> name_age();

    // SELECT d.firstname AS director_firstname, a.firstname AS actor_firstname FROM Director d LEFT OUTER JOIN Actor a ON d.id = a.director_id

//    @Query
//            ("SELECT Director.firstname AS Director_firstname, Director.lastname AS director_lastname, Director.age,\n" +
//            "       Actor.firstname AS actor_firstname, Actor.lastname AS actor_lastname, Actor.date_of_birth\n" +
//            "FROM Director\n" +
//            "INNER JOIN Actor ON Director.lastname = Actor.lastname")
//            public List<Director> inner_name_one();
//
//    @Query
//            ("SELECT Director.firstname AS Director_firstname, Director.lastname AS director_lastname, Director.age,\n" +
//                    "       Actor.firstname AS actor_firstname, Actor.lastname AS actor_lastname, Actor.date_of_birth\n" +
//                    "FROM Director\n" +
//                    "INNER JOIN Actor ON Director.lastname = Actor.lastname")
//    public List<Director> outer_name_one();
//

//
//    // Этот запрос добавит столбец average_director_age, который будет содержать средний возраст
//    // всех режиссеров в таблице director для каждой строки.
//    @Query
//            ("SELECT d.firstname, d.lastname, d.age,\n" +
//                    "       AVG(d.age) AS average_director_age\n" +
//                    "FROM Director d")
//    public List<Director> sr_age();



}
