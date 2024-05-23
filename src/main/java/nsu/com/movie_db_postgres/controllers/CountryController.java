package nsu.com.movie_db_postgres.controllers;

import nsu.com.movie_db_postgres.models.CommonResponse;
import nsu.com.movie_db_postgres.models.Country;
import nsu.com.movie_db_postgres.models.Studio;
import nsu.com.movie_db_postgres.repositories.CountryRepository;
import nsu.com.movie_db_postgres.repositories.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/country")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getAllStudio() {

        var commonResponse = new CommonResponse();
        commonResponse.data = countryRepository.findAll();
        commonResponse.message = "All studio";

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> addStudio(@RequestBody Country studio) {

        studio = countryRepository.save(studio);

        var commonResponse = new CommonResponse();
        commonResponse.data = studio;
        commonResponse.message = "added studio: " + studio.getCountryName();

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResponse> deleteStudio(@PathVariable Integer id) {
        {
            CommonResponse cr = new CommonResponse();
            HttpStatus resp;

            if (countryRepository.existsById(id)) {
                cr.message = "Deleted Country with id: " + id;
                resp = HttpStatus.OK;
            } else {
                cr.message = "Country not found with id: " + id;
                resp = HttpStatus.NOT_FOUND;
            }

            return new ResponseEntity<>(cr, resp);
        }
    }

}