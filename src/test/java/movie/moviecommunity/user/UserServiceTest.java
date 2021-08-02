package movie.moviecommunity.user;

import org.junit.Assert;
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
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{

        User user = new User();
        user.setNickname("hi3");
        user.setPassword("ede");
        LocalDateTime d = LocalDateTime.parse("2021-07-15 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        user.setReg_date(d);

        int regId = userService.register(user);
        Assertions.assertEquals(user, userRepository.findUser(regId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_닉네임_확인() throws Exception{
        User user1 = new User();
        User user2 = new User();

        user1.setNickname("hi3");
        user1.setPassword("ede");
        LocalDateTime d = LocalDateTime.parse("2021-07-15 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        user1.setReg_date(d);

        user2.setNickname("hi3");
        user2.setPassword("ede");
        LocalDateTime d1 = LocalDateTime.parse("2021-07-15 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        user2.setReg_date(d1);

        userService.register(user1);
        userService.register(user2);
        Assert.fail("아이디가 중복됨");
    }


}