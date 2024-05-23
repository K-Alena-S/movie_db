package nsu.com.movie_db_postgres.controllers;


import nsu.com.movie_db_postgres.repositories.DirectorRepository;
import nsu.com.movie_db_postgres.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nsu.com.movie_db_postgres.models.CommonResponse;
import nsu.com.movie_db_postgres.models.Director;
import nsu.com.movie_db_postgres.models.Movie;

import java.util.List;

@RestController
@RequestMapping("api/v1/directors")
public class DirectorsController {

    @Autowired
    public DirectorRepository directorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getAllDirectors() {

        var commonResponse = new CommonResponse();
        commonResponse.data = directorRepository.findAll();
        commonResponse.message = "All directors";

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> addDirector(@RequestBody Director director) {

        director = directorRepository.save(director);

        var commonResponse = new CommonResponse();
        commonResponse.data = director;
        commonResponse.message = "added director: " + director.getId();

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

//        @RequestMapping(value = "/sort", method = RequestMethod.GET)
//    public ResponseEntity<CommonResponse> getDirectorsSortByDate() {
//
//        var commonResponse = new CommonResponse();
//
//
//        commonResponse.data = directorRepository.sortByDate();
//        commonResponse.message = "Directors between sort ";
//
//        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
//    }

    /**
     * Method that deletes a director. Before the director is deleted
     * we set the "director" column for the movie row to null.
     * Meaning, we don't delete the whole movie row as a movie
     * can exist wihout having value in the genre column.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResponse> deleteDirector(@PathVariable Integer id) {
        {
            CommonResponse cr = new CommonResponse();
            HttpStatus resp;

            if (directorRepository.existsById(id)) {

                List<Movie> movieList = movieRepository.findAll();
                Movie toBeUpdated = null;

                for (int i = 0; i < movieList.size(); i++) {
                    if (movieList.get(i).getDirector() != null && movieList.get(i).getDirector().getId() == id) {
                        toBeUpdated = movieList.get(i);
                        toBeUpdated.setDirector(null);
                    }
                }

                movieRepository.save(toBeUpdated);
                directorRepository.deleteById(id);

                cr.message = "Deleted Director with id: " + id;
                resp = HttpStatus.OK;
            } else {
                cr.message = "Director not found with id: " + id;
                resp = HttpStatus.NOT_FOUND;
            }

            return new ResponseEntity<>(cr, resp);
        }
    }
}