package by.yurachel.web_app.config.security;

import by.yurachel.web_app.model.user.Permission;
import by.yurachel.web_app.model.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserDetailsService(@Qualifier("userService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .antMatchers("/phones").hasAuthority("ACCESS_PHONES")
//                .antMatchers("/phones/new").hasRole("ADMIN")
//                .antMatchers("/phones/{\\d+\\w+}").hasAnyRole("ADMIN")
//                .antMatchers("/phones/{\\d+}/updatePhone{\\w+}").hasAnyRole("ADMIN", "MANAGER")
//                .and()
//                .httpBasic();
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/phones/{\\d+}","/phones").hasAuthority(Permission.DEVELOPERS_READ.getPermission())
                .antMatchers( "/phones/new"
                        ,"/phones/{\\d+}/updatePhone").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission())
                .antMatchers("/users", "/users/new").hasRole(Role.ADMIN.name())
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .rememberMe().userDetailsService(userDetailsService).tokenValiditySeconds(2592000);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
