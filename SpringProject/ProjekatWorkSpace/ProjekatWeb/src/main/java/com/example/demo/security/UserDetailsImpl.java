package com.example.demo.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import model.Korisnik;


public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String ime;
	private String prezime;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(Korisnik k) {
		this.username = k.getUsername();
		this.password = k.getPassword();
		this.ime = k.getIme();
		this.prezime = k.getPrezime();
		System.out.println(k.getUloga().getNaziv());
		this.authorities = Arrays.asList(new SimpleGrantedAuthority(k.getUloga().getNaziv()));
	}
	
	 @Override
	 public Collection<GrantedAuthority> getAuthorities() { 
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