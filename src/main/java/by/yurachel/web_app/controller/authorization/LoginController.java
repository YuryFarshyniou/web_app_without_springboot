package by.yurachel.web_app.controller.authorization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/login")
//public class LoginController {
//    @GetMapping()
//    public String login() {
//        return "authorization/login";
//    }
//
//    @PostMapping()
//    public String loginPage(@RequestParam(value = "error", required = false) String error,
//                            @RequestParam(value = "logout", required = false) String logout,
//                            Model model) {
////        String errorMessge = null;
////        if (error != null) {
////            errorMessge = "Username or Password is incorrect !!";
////        }
////        if (logout != null) {
////            errorMessge = "You have been successfully logged out !!";
////        }
////        model.addAttribute("errorMessge", errorMessge);
//        return "redirect:/home";
//    }
//}
