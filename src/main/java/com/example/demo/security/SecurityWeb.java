package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityWeb extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ROLE");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		autoriza requests 
//        /categorias -> permite todos
//        /qualquer request - autenticado e
//        gerenciadoment sessao _ politica de criação de sessao -> stateless e
//        csrf desabilitado

		http
			.authorizeRequests()
			.antMatchers("/situacoes").permitAll()
			.anyRequest().authenticated().and()
			.httpBasic().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.csrf().disable();
			
	}

	
}
