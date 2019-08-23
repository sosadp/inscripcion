package com.djsm.inscripcion.security;

import com.djsm.inscripcion.model.User;
import com.djsm.inscripcion.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dsosa on 7/25/2019.
 */
@Service("detailsService")
public class UserSecurity implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User us= userRepository.findByName(userName);

        List<GrantedAuthority> roles= new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails userDetails= new org.springframework.security.core.userdetails.User(us.getName(),us.getPass(),roles);

        return userDetails;
    }
}
