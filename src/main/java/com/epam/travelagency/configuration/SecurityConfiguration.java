package com.epam.travelagency.configuration;

import com.epam.travelagency.entity.Customer;
import com.epam.travelagency.service.CustomerService;
import com.epam.travelagency.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

/*    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .passwordEncoder(bCryptPasswordEncoder);
    }
    */

    @Autowired
    private CustomerServiceImpl customerService;

    @Override
    protected void configure(HttpSecurity config) throws Exception {
        config
                .authorizeRequests()
                .antMatchers("/blog").permitAll()
                .antMatchers("/countries").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/tours").permitAll()
                .antMatchers("/hotels").permitAll()
                .antMatchers("/contracts").hasRole("USER")
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/index").permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll();

        config.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        for (Customer customer : customerService.getAll()) {
            builder.inMemoryAuthentication()
                    .withUser(customer.getLogin()).password(customer.getPassword()).roles("USER");
        }
/*            builder.inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER");*/
    }
}
