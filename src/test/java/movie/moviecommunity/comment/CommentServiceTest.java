package movie.moviecommunity.comment;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CommentServiceTest {

    @Autowired CommentService commentService;
    @Autowired CommentRepository commentRepository;

    @Test
    @Rollback(false)
    public void 댓글등록() throws Exception{
        Comment comment = new Comment();
        comment.setContent("hh");
        LocalDateTime d = LocalDateTime.parse("2021-07-15 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        comment.setDate(d);

        int cotId = commentService.saveComment(comment);
        Assertions.assertEquals(comment, commentRepository.findComment(cotId));

    }


}