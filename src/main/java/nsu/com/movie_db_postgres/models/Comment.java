package nsu.com.movie_db_postgres.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public abstract class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String commentName;

    public Integer getId(){
        return id;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setStudioName(String studioName) {
        this.commentName = studioName;
    }

    public abstract List<Object[]> getCommentsWithRowNumber();

    public abstract List<Object[]> getCommentsWithLateralJoin();

    public abstract List<Object[]> getCommentsWithLateral();
}
