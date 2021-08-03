package movie.moviecommunity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class UserRegister {

    @NotEmpty(message = "닉네임을 설정해주세요.")
    @Column(unique = true)
    private String nickname;

    @NotEmpty(message = "이름을 설정해주세요")
    private String name;

    @Email(message = "이메일 형식이어야 합니다.")
    @NotEmpty(message = "이메일을 설정해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호를 설정해주세요.")
    private String password;

}
