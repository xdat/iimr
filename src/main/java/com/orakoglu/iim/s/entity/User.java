package com.orakoglu.iim.s.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.orakoglu.iim.s.enums.Role;

@Entity
public class User {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	private @NotBlank @Size(max = 20) String username;
	private @NotBlank @Size(max = 40) String password;
	private @NotNull @Enumerated(EnumType.ORDINAL) Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
