package movie.moviecommunity.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/write")
    public String writeContext(Model model){
        model.addAttribute("boardWrite", new BoardWrite());
        return "boards/postBoard";
    }

    @PostMapping("/board/write")
    public String write(@Valid BoardWrite boardWrite, BindingResult result){

        if (result.hasErrors()){
            return "boards/postBoard";
        }

        Board board = new Board();
        board.setTitle(boardWrite.getTitle());
        board.setContent(boardWrite.getContent());

        boardService.saveBoard(board);
        return "redirect:/";
    }

    @GetMapping("/boards")
    public String list(Model model){
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "boards/boardList";
    }


}
