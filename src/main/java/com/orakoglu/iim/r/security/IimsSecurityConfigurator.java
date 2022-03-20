package com.orakoglu.iim.r.security;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class IimsSecurityConfigurator extends WebSecurityConfigurerAdapter {

	@Autowired
	IimsAuthenticationProvider iimsAuthenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http//
				.httpBasic().disable() // No Http Basic Login
				.csrf().disable() // No CSRF token
				.formLogin().disable() // No Form Login
				.logout().disable() // No Logout
				// No Session pls
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//
				.and().authenticationProvider(iimsAuthenticationProvider).addFilterBefore(getFilter(), AnonymousAuthenticationFilter.class).authorizeRequests()//
				.requestMatchers(getRequestMatchers()).authenticated()//
				
				;

		;
	}

	private RequestMatcher getRequestMatchers() {
		return new OrRequestMatcher(new AntPathRequestMatcher("/**"));
	}
	
	private Filter getFilter() throws Exception {
		return new IimsAuthenticationTokenFilter();
	}

	@Autowired
	public void configuraGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(iimsAuthenticationProvider);

	}

}
