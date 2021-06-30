package by.yurachel.web_app.controller.home;

import by.yurachel.web_app.model.phone.impl.Phone;
import by.yurachel.web_app.service.IService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

    private IService<Phone> service;

    public HomeController(IService<Phone> service) {
        this.service = service;
    }

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("users", service.findAll());
        return "home/home";
    }
}
