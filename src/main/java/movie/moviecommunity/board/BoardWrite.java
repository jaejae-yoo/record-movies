package movie.moviecommunity.board;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class BoardWrite {

    @NotEmpty(message = "제목을 작성해주세요.")
    private String title;

    @NotEmpty(message = "내용을 작성해주세요.")
    private String content;

    //private LocalDateTime date;

    @Column(name = "view_count")
    private int viewCount;

}
