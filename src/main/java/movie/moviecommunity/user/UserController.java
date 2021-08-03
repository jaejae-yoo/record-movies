package movie.moviecommunity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/new")
    public String createForm(Model model){
        model.addAttribute("userRegister", new UserRegister());
        return "users/registerUserForm";
    }

    @PostMapping("/users/new")
    public String register(@Valid UserRegister register, BindingResult result){

        if (result.hasErrors()){
            return "users/registerUserForm";
        }

        User user = new User();
        user.setName(register.getName());
        user.setNickname(register.getNickname());
        user.setPassword(register.getPassword());
        user.setEmail(register.getEmail());

        userService.register(user);
        return "redirect:/";
    }

}
