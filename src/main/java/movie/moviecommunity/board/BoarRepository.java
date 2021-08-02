package movie.moviecommunity.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoarRepository {

    private final EntityManager em;

    public void save(Board board){
        em.persist(board);
    }

    public Board findBoard(int id){
        return em.find(Board.class, id);
    }

    public List<Board> findBoards() {
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }

}
