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
    @ResponseBody
    @PostMapping
    public Object postLogin(@RequestParam("email") String email, @RequestParam("password") String password,
                            @RequestParam("radiobox") String radiobox, HttpServletResponse response) {
        Optional<User> check = loginService.check(email.trim(), password.trim(), radiobox.trim());
        if (!check.isPresent())
            return "login failed";

        Cookie userCookie = new Cookie("%USERTYPE%", radiobox.trim());
        Cookie idCookie = new Cookie("%ID%", String.valueOf(check.get().getId()));
        response.addCookie(userCookie);
        response.addCookie(idCookie);
        return check.get();
    }
    @ResponseBody
    @GetMapping
    public Object getLogin()
    {
        return "loginIndex";
    }
}
