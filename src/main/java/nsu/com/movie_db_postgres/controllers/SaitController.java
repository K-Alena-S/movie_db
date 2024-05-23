package nsu.com.movie_db_postgres.controllers;

import nsu.com.movie_db_postgres.models.CommonResponse;
import nsu.com.movie_db_postgres.models.Sait;
import nsu.com.movie_db_postgres.models.Studio;
import nsu.com.movie_db_postgres.repositories.SaitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sait")
public class SaitController {

    @Autowired
    private SaitRepository saitRepository;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getAllStudio() {

        var commonResponse = new CommonResponse();
        commonResponse.data = saitRepository.findAll();
        commonResponse.message = "All studio";

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> addStudio(@RequestBody Sait sait) {

        sait = saitRepository.save(sait);

        var commonResponse = new CommonResponse();
        commonResponse.data = sait;
        commonResponse.message = "added studio: " + sait.getSaitName();

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResponse> deleteStudio(@PathVariable Integer id) {
        {
            CommonResponse cr = new CommonResponse();
            HttpStatus resp;

            if (saitRepository.existsById(id)) {
                cr.message = "Deleted Sait with id: " + id;
                resp = HttpStatus.OK;
            } else {
                cr.message = "Sait not found with id: " + id;
                resp = HttpStatus.NOT_FOUND;
            }

            return new ResponseEntity<>(cr, resp);
        }
    }

}