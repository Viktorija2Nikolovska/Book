package finki.ukim.mk.books.service;

import finki.ukim.mk.books.model.User;
import finki.ukim.mk.books.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
    UserDetails loadUserByUsername(String s);
    User login(String username, String password);
}

