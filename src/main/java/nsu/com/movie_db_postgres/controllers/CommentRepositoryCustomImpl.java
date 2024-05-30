package nsu.com.movie_db_postgres.controllers;

import nsu.com.movie_db_postgres.models.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


public class CommentRepositoryCustomImpl extends Comment {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getCommentsWithRowNumber() {
        String sql = "SELECT c.id, c.commentName, ROW_NUMBER() OVER (ORDER BY c.commentName) as row_number " +
                "FROM Comment c";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
    /*
    * ROW_NUMBER() OVER (ORDER BY c.commentName) создает порядковый номер для каждого комментария
    * в зависимости от значения commentName.
    * entityManager.createNativeQuery(sql) создает и выполняет SQL запрос.
    * Результат запроса возвращается как список массивов объектов, где каждый массив содержит идентификатор
    *  комментария, его имя и порядковый номер.
    */


    @Override
    public List<Object[]> getCommentsWithLateralJoin() {
        String sql = "SELECT c.id, c.commentName, s.studioName FROM Comment c " +
                "LEFT JOIN LATERAL (SELECT s.studioName FROM Studio s WHERE s.id = c.studioId) s ON TRUE";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
    /*
    * LEFT JOIN LATERAL (SELECT s.studioName FROM Studio s WHERE s.id = c.studioId) s ON TRUE выполняет левое
    * соединение с таблицей Studio по полю studioId и возвращает имя студии для каждого комментария.
    * LATERAL позволяет выполнять вложенный запрос в контексте каждого ряда внешней таблицы, в данном случае таблицы Comment.
    * Результат запроса возвращается как список массивов объектов, где каждый массив содержит идентификатор комментария,
    * его имя и имя студии, связанной с комментарием.
     */

    @Override
    public List<Object[]> getCommentsWithLateral() {
        String sql = "WITH RECURSIVE comment_tree AS (\n" +
                "    SELECT * FROM Comment WHERE parent_id IS NULL\n" +
                "    UNION ALL\n" +
                "    SELECT c.* FROM Comment c JOIN comment_tree t ON c.parent_id = t.id\n" +
                ")\n" +
                "SELECT * FROM comment_tree";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}