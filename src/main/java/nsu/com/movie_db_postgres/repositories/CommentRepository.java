package nsu.com.movie_db_postgres.repositories;

import nsu.com.movie_db_postgres.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {


}
