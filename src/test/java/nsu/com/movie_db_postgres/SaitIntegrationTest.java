package nsu.com.movie_db_postgres;

import nsu.com.movie_db_postgres.models.Sait;
import nsu.com.movie_db_postgres.repositories.SaitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@SpringBootTest
public class SaitIntegrationTest {

    @Autowired
    private SaitRepository saitRepository;

    @Test
    public void testSaveAndFindSait() {
        // Arrange
        Sait sait = new Sait();
        sait.setSaitName("Google");

        // Act
        saitRepository.save(sait);
        Sait foundSait = saitRepository.findById(sait.getId()).orElse(null);

        // Assert
        assertThat(foundSait).isNotNull();
        assertThat(foundSait.getSaitName()).isEqualTo("Google");
    }

    @Test
    public void testFindById() {
        // Arrange
        Sait sait = new Sait();
        sait.setSaitName("Google");
        saitRepository.save(sait);

        // Act
        Sait foundSait = saitRepository.findById(sait.getId()).orElse(null);

        // Assert
        assertNotNull(foundSait);
        assertEquals("Google", foundSait.getSaitName());
    }

    @Test
    public void testSave() {
        // Arrange
        Sait sait = new Sait();
        sait.setSaitName("Amazon");

        // Act
        saitRepository.save(sait);

        // Assert
        assertNotNull(sait.getId());
    }

    @Test
    public void testDelete() {
        // Arrange
        Sait sait = new Sait();
        sait.setSaitName("Twitter");
        saitRepository.save(sait);

        // Act
        saitRepository.delete(sait);

        // Assert
        assertFalse(saitRepository.existsById(sait.getId()));

    }
}
