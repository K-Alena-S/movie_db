//package nsu.com.movie_db_postgres.models;
//
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
//public class Studio {
//
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Integer id;
//
//    private String studioName;
//
//    @OneToMany(mappedBy = "studio",
//            fetch = FetchType.LAZY)
//    private List<Studio> studi = new ArrayList<>();
//
//    public Integer getId(){
//        return id;
//    }
//
//    public String getStudioName() {
//        return studioName;
//    }
//
//    public void setStudioName(String studioName) {
//        this.studioName = studioName;
//    }
//
////    public List<Movie> getMovie() {
////        return movie;
////    }
//
////    public void setMovie(List<Movie> movie) {
////        this.movie = movie;
////    }
//}
