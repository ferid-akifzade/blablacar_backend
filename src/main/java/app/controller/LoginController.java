package app.controller;

import app.libs.User;
import app.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping
    public Object postLogin(@RequestParam("email") String email, @RequestParam("password") String password,
                            @RequestParam("radiobox") String radiobox, HttpServletResponse response) {
        Optional<User> check = loginService.check(email, password, radiobox);
        if (!check.isPresent())
            return "index";

        Cookie userCookie = new Cookie("%USERTYPE%", radiobox);
        Cookie idCookie = new Cookie("%ID%", String.valueOf(check.get().getId()));
        response.addCookie(userCookie);
        response.addCookie(idCookie);
        return check.get();
    }
    @GetMapping
    public Object getLogin()
    {
        return "index";
    }
}
