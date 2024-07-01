package com.tejas.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BCryptPasswordEncoder encoder;

	/*
	 * http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
	 * http.formLogin(); http.httpBasic();
	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/balance").authenticated().antMatchers("/statement").authenticated()
//				.antMatchers("/myloan").authenticated().antMatchers("/home").permitAll().antMatchers("/contact")
//				.permitAll().and().formLogin().and().httpBasic();
//	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("ashok").password("ashok@123").authorities("admin").and()
//				.withUser("raju").password("raju@123").authorities("read").and().withUser("mahesh")
//				.password("mahesh@123").authorities("read").and().passwordEncoder(NoOpPasswordEncoder.getInstance());
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home").permitAll().antMatchers("/balance").authenticated()
				.antMatchers("/statement").authenticated().antMatchers("/myloan").authenticated()
				.antMatchers("/contact").permitAll().and().formLogin().and().httpBasic();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT user_name, user_pwd, user_enabled FROM user WHERE user_name = ?")
				.authoritiesByUsernameQuery("SELECT user_name, user_role FROM user WHERE user_name = ?")
				.passwordEncoder(encoder);

	}

}
