package nsu.com.movie_db_postgres.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Sait {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

//    @OneToOne(mappedBy = "studio",
//    fetch = FetchType.LAZY)
//    private Studio studio;

    @Column
    private String saitName;

    public Integer getId(){
        return id;
    }

    public String getSaitName() {
        return saitName;
    }

    public void setSaitName(String saitName) {
        this.saitName = saitName;
    }

}