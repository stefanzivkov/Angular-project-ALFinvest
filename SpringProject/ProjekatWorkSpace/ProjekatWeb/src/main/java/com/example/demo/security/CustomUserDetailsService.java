package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.KorisnikRepository;

import model.Korisnik;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
 
    @Autowired
    private KorisnikRepository korisnikRepository;  
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Korisnik user = korisnikRepository.findByUsername(username);
//		UserDetailsImpl userDetails = new UserDetailsImpl(user);
//		return userDetails;
		
		Optional<Korisnik> k = Optional.of(korisnikRepository.findByUsername(username));
		
		k.orElseThrow(() -> new UsernameNotFoundException("Nije pronadjeno korisnicko ime: " + username));
		
		return k.map(UserDetailsImpl::new).get();
    }
}
