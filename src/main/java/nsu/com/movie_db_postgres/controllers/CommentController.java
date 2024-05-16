package nsu.com.movie_db_postgres.controllers;

import nsu.com.movie_db_postgres.models.Comment;
import nsu.com.movie_db_postgres.models.CommonResponse;
import nsu.com.movie_db_postgres.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getAllComment() {

        var commonResponse = new CommonResponse();
        commonResponse.data = commentRepository.findAll();
        commonResponse.message = "All comment";

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> addComment(@RequestBody Comment comment) {

        comment = commentRepository.save(comment);

        var commonResponse = new CommonResponse();
        commonResponse.data = comment;
        commonResponse.message = "added comment: " + comment.getCommentName();

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResponse> deleteComment(@PathVariable Integer id) {

            CommonResponse cr = new CommonResponse();
            HttpStatus resp;

            if (commentRepository.existsById(id)) {
                cr.message = "Deleted Comment with id: " + id;
                resp = HttpStatus.OK;
            } else {
                cr.message = "Comment not found with id: " + id;
                resp = HttpStatus.NOT_FOUND;
            }

            return new ResponseEntity<>(cr, resp);
        }
    }
