package com.example.demo.service;

import com.example.demo.model.Rol;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


            Optional<com.example.demo.model.User> user = userRepository.getUserByName(s);

            Set<GrantedAuthority> authorizations = new HashSet<>();
            for(Rol rol:user.get().getRoles())
            {
                GrantedAuthority authority = new SimpleGrantedAuthority(rol.getName());
                authorizations.add(authority);
            }


            User userDatail = new  User(user.get().getName(),"{noop}" + user.get().getPassword(),true,true,true,true,authorizations);
            return userDatail;
    }
}
