package movie.moviecommunity.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public void save(Comment comment){
        em.persist(comment);
    }

    public Comment findComment(int id){
        return em.find(Comment.class, id);
    }

    public List<Comment> findComments() {
        return em.createQuery("select c from Comment c", Comment.class)
                .getResultList();
    }

}
