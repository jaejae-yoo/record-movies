package movie.moviecommunity.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public int saveComment(Comment comment){
        commentRepository.save(comment);
        return comment.getId();
    }

    public List<Comment> findComments() {
        return commentRepository.findComments();
    }

    public Comment findComment(int commentId){
        return commentRepository.findComment(commentId);
    }

}
