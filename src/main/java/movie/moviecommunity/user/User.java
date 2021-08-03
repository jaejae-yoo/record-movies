package movie.moviecommunity.user;

import lombok.Getter;
import lombok.Setter;
import movie.moviecommunity.comment.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id", nullable = false)
    private int id;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    //@Column(nullable = false)
    private LocalDateTime reg_date;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();



}
