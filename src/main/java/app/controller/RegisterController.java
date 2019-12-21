package app.controller;

import app.libs.User;
import app.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public Object registerPost(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email,
                               @RequestParam("password") String password, @RequestParam("radiobox") String radiobox,
                               @RequestParam("gender") String gender, @RequestParam("phoneNum") String phoneNum,
                               @RequestParam("vehcile") String vehcile, @RequestParam("seats") String seats) {
        Optional<User> register = registerService.register(name, surname, email, password, radiobox, gender, phoneNum, vehcile, Integer.parseInt(seats));
        if (register.isPresent()) {
            return register;
        }
        return "index";
    }
}
