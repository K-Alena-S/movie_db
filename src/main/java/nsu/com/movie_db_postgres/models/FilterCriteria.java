package nsu.com.movie_db_postgres.models;

import org.springframework.data.util.Pair;

import java.util.List;

public class FilterCriteria {
    private List<Pair<String, Object>> criteria;

    public List<Pair<String, Object>> getCriteria() {
        return criteria;
    }

    // Методы для добавления и удаления критериев
}
