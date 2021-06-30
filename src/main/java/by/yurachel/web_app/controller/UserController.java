package by.yurachel.web_app.controller;

import by.yurachel.web_app.controller.home.HomeController;

import by.yurachel.web_app.model.user.impl.User;
import by.yurachel.web_app.service.IService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

    private IService<User> service;

    public UserController(IService<User> service) {
        this.service = service;
    }

    @GetMapping()
    public String phoneList(Model model) {
        model.addAttribute("users", service.findAll());
        return "users/users";
    }

    @GetMapping("/new")
    public String addNewPhone(Model model) {
        model.addAttribute("newUser", new User());
        return "users/addUser";
    }

    @PostMapping
    public String create(@ModelAttribute("newUser") User user) {
        System.out.println(user);
        service.create(user);
        return "redirect:/users";
    }
}
