package movie.moviecommunity.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoarRepository boarRepository;

    @Transactional
    public int saveBoard(Board board){
        boarRepository.save(board);
        return board.getId();
    }

    public List<Board> findBoards(){
        return boarRepository.findBoards();
    }

    public Board findBoard(int boardId){
        return boarRepository.findBoard(boardId);
    }

}
