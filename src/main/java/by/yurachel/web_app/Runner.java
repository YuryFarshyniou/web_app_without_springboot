package by.yurachel.web_app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Runner {
    public static void main(String[] args) {
        PasswordEncoder e = new BCryptPasswordEncoder();
        String s = e.encode("user");
        System.out.println(s);
    }
}
