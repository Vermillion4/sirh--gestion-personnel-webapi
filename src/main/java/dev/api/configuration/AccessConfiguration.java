package dev.api.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AccessConfiguration extends WebSecurityConfigurerAdapter{

		@Bean
		public PasswordEncoder passwordEncoder() { 
			return new BCryptPasswordEncoder();
		}
		
		//@Autowired private PasswordEncoder passwordEncoder; 
		@Autowired private DataSource dataSource; 
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			//auth.eraseCredentials(true);
			auth.jdbcAuthentication() 
			.dataSource(dataSource) 
			/*.passwordEncoder(passwordEncoder)
			.usersByUsernameQuery("select NOM_UTILISATEUR, MOT_DE_PASSE, EST_ACTIF from UTILISATEUR where NOM_UTILISATEUR=?") 
			.authoritiesByUsernameQuery("select NOM_UTILISATEUR,ROLE from UTILISATEUR where NOM_UTILISATEUR = ?")
			*/
			.withDefaultSchema()
			.withUser("user").password("pass").roles("USER")
			; 
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http.csrf().disable();
			http.headers().frameOptions().disable();
		}
		
	}