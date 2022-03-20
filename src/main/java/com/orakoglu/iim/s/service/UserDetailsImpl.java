package com.orakoglu.iim.s.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.orakoglu.iim.s.entity.User;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 7855110879656215646L;

	private Long id;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	private UserDetailsImpl(User user) {
		id = user.getId();
		username = user.getUsername();
		password = user.getPassword();
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(new SimpleGrantedAuthority(user.getRole().name()));
		authorities = list;
	}

	public static UserDetailsImpl build(User user) {
		return new UserDetailsImpl(user);

	}

	public Long getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
