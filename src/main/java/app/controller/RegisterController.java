package app.controller;

import app.libs.User;
import app.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @ResponseBody
    @PostMapping
    public Object registerPost(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email,
                               @RequestParam("password") String password, @RequestParam("radiobox") String radiobox,
                               @RequestParam("gender") String gender, @RequestParam("phoneNum") String phoneNum,
                               @RequestParam(value = "vehicle",defaultValue = "") String vehicle,
                               @RequestParam(value = "seats",defaultValue = "0") String seats) {
        Optional<User> register = registerService.register(name.trim(), surname.trim(),
                email.trim(), password.trim(), radiobox.trim(), gender.trim(), phoneNum.trim(), vehicle.trim(), Integer.parseInt(seats.trim()));
        if (register.isPresent()) {
            return register;
        }
        return "register failed";
    }
    @ResponseBody
    @GetMapping
    public String get()
    {
        return "registerIndex";
    }
}
