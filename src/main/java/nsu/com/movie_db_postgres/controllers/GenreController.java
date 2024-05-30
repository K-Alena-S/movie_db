package nsu.com.movie_db_postgres.controllers;

import nsu.com.movie_db_postgres.models.FilterCriteria;
import nsu.com.movie_db_postgres.repositories.GenreRepository;
import nsu.com.movie_db_postgres.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nsu.com.movie_db_postgres.models.CommonResponse;
import nsu.com.movie_db_postgres.models.Genre;
import nsu.com.movie_db_postgres.models.Movie;

import java.util.List;

@RestController
@RequestMapping("api/v1/genre")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getAllGenre() {

        var commonResponse = new CommonResponse();
        commonResponse.data = genreRepository.findAll();
        commonResponse.message = "All genre";

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> addGenre(@RequestBody Genre genre) {

        genre = genreRepository.save(genre);

        var commonResponse = new CommonResponse();
        commonResponse.data = genre;
        commonResponse.message = "added genre: " + genre.getGenreName();

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResponse> deleteGenre(@PathVariable Integer id) {
        {
            CommonResponse cr = new CommonResponse();
            HttpStatus resp;

            if (genreRepository.existsById(id)) {

                List<Movie> movieList = movieRepository.findAll();
                Movie toBeUpdated = null;

                for (int i = 0; i < movieList.size(); i++) {
                    if (movieList.get(i).getGenre() != null && movieList.get(i).getGenre().getId() == id) {
                        toBeUpdated = movieList.get(i);
                        toBeUpdated.setGenre( null);
                    }
                }

                movieRepository.save(toBeUpdated);
                genreRepository.deleteById(id);

                cr.message = "Deleted Genre with id: " + id;
                resp = HttpStatus.OK;
            } else {
                cr.message = "Genre not found with id: " + id;
                resp = HttpStatus.NOT_FOUND;
            }

            return new ResponseEntity<>(cr, resp);
        }
    }

//    public List<Genre> findGenres(FilterCriteria filterCriteria) {
//        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM Genre");
//
//        if (filterCriteria != null && !filterCriteria.getCriteria().isEmpty()) {
//            queryBuilder.append(" WHERE ");
//
//            for (int i = 0; i < filterCriteria.getCriteria().size(); i++) {
//                Pair<String, Object> criterion = filterCriteria.getCriteria().get(i);
//
//                queryBuilder
//                        .append(criterion.getKey())
//                        .append(" = ")
//                        .append("$")
//                        .append(i + 1);
//
//                if (i < filterCriteria.getCriteria().size() - 1) {
//                    queryBuilder.append(" AND ");
//                }
//            }
//        }
//
//        // Создание запроса
//        Query query = entityManager.createNativeQuery(queryBuilder.toString());
//
//        // Добавление параметров запроса
//        for (int i = 1; i <= filterCriteria.getCriteria().size(); i++) {
//            query.setParameter(i, filterCriteria.getCriteria().get(i - 1).getValue());
//        }
//
//        return query.getResultList();
//    }

}
