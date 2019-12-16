package app.controller;

import app.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {
private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping
    public String postLogin(@RequestParam("email") String email, @RequestParam("password") String password,
                            @RequestParam("radiobox") String radiobox, HttpServletResponse response){
        int check = loginService.check(email, password, radiobox);
        if(check==-1){
            return "login";
        }
        Cookie userCookie = new Cookie("%USERTYPE%",radiobox);
        Cookie idCookie = new Cookie("%ID%",String.valueOf(check));
        response.addCookie(userCookie);
        response.addCookie(idCookie);
        return "redirect:/";
    }


}
