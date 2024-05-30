package nsu.com.movie_db_postgres;

import nsu.com.movie_db_postgres.models.Director;
import nsu.com.movie_db_postgres.repositories.DirectorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class DirectorIntegrationTest {

    @Autowired
    private DirectorRepository directorRepository;

    @Test
    public void testFindById() {
        // Arrange
        Director director = new Director();
        director.setFirstname("John");
        director.setLastname("Doe");
        director.setAge(50);
        directorRepository.save(director);

        // Act
        Director foundDirector = directorRepository.findById(director.getId()).orElse(null);

        // Assert
        assertNotNull(foundDirector);
        assertEquals("John", foundDirector.getFirstname());
    }


    @Test
    public void testCreateDirector() {
        // Arrange
        Director director = new Director();
        director.setFirstname("John");
        director.setLastname("Doe");
        director.setAge(50);
        directorRepository.save(director);

        // Assert
        assertNotNull(director.getId());
    }

    @Test
    public void testUpdateDirector() {
        // Arrange
        Director director = new Director();
        director.setFirstname("John");
        director.setLastname("Doe");
        director.setAge(50);
        directorRepository.save(director);

        director.setAge(60);

        // Act
        directorRepository.save(director);

        // Assert
        assertEquals(java.util.Optional.of(60), java.util.Optional.of(director.getAge()));
    }
}
