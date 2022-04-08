package tr.gov.sayistay.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import tr.gov.sayistay.filter.JWTFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Inject
	private UserDetailsService userDetailsService;
	@Inject
	private JWTFilter jwtFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
		  .cors()
		  .and()
		  .csrf()
		     .disable()
		  .authorizeRequests()
		     .antMatchers("/version", "/login")
		        .permitAll()
		     .antMatchers("/doktor")
		        .hasAnyAuthority("admin", "user")
		  .anyRequest()
		     .authenticated()
		  .and()
		     .sessionManagement()
		        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		  //.and().formLogin();
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		// @formatter:on
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// @formatter:off
//		auth.inMemoryAuthentication()
//		// sifre 123
//		 .withUser("levent").password("$2a$10$MF1bUb9Ik1iIs0n8LJYeZOli/S2lMCMJKOCbHxgc.u/l5xxwLbAuy").roles("admin").and()
//		 // sifre abc
//		 .withUser("sabuha").password("$2a$10$jqHnEaE4i8T5Z039Y8yFh.DiacIUADQgp6yoi76/5Efg96fVLhvY2").roles("user")
//		 ;
//		 // @formatter:on
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
		 // @formatter:on
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		// return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		//
		System.out.println(new BCryptPasswordEncoder().encode("abc"));
		System.out.println(new BCryptPasswordEncoder().encode("abc"));
		System.out.println(new BCryptPasswordEncoder().encode("abc"));
		System.out.println(new BCryptPasswordEncoder().encode("abc"));
		System.out.println(new BCryptPasswordEncoder().encode("abc"));
	}

}
