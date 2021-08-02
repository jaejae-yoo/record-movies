package movie.moviecommunity.board;

import lombok.Getter;
import lombok.Setter;
import movie.moviecommunity.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int id;

    private String title;
    private String content;
    private LocalDateTime date;

    @Column(name = "view_count")
    private int viewCount;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

}
