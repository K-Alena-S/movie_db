package nsu.com.movie_db_postgres;

import nsu.com.movie_db_postgres.repositories.GenreRepository;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.transaction.Transactional;

import static junit.framework.TestCase.assertEquals;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class SpringBootJPAIntegrationTest {
//
//    @Autowired
//    private GenericEntityRepository genericEntityRepository;
//
//    @Test
//    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
//        GenericEntity genericEntity = genericEntityRepository
//                .save(new GenericEntity("test"));
//        GenericEntity foundEntity = genericEntityRepository
//                .findOne(genericEntity.getId());
//
//        assertNotNull(foundEntity);
//        assertEquals(genericEntity.getValue(), foundEntity.getValue());
//    }
//}

//@SpringBootTest
//@ContextConfiguration(initializers = {IntegrationSqlTest.Initializer.class})
//@Testcontainers
//class IntegrationSqlTest {
//
//    @Autowired
//    GenreRepository genreRepository;
//
//    @Container
//    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:13")
//            .withDatabaseName("postgre")
//            .withUsername("postgre")
//            .withPassword("postgre")
//            .withInitScript("db.sql");
//
//    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//            TestPropertyValues.of(
//                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
//                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
//                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
//
//            ).applyTo(configurableApplicationContext.getEnvironment());
//        }
//    }
//    @Test
//    @Transactional
//    public void CountShouldBeCorrect() {
//        long count = genreRepository.count();
//        assertEquals(3, count);
//
//    }
//
////    @Test
////    @Transactional
////    public void animalsShouldBeCorrect() {
////        List<Genre> genre = genreRepository.findAll();
////        String[] actualAnimals = {"animal1", "animal2", "animal3"};
////        assertArrayEquals(actualAnimals, animals.stream().map(animal -> animal.getName()).toArray());
////    }
//}
