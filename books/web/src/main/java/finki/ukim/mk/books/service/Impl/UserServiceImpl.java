package finki.ukim.mk.books.service.Impl;

import finki.ukim.mk.books.model.User;
import finki.ukim.mk.books.model.enums.Role;
import finki.ukim.mk.books.repository.UserJpaRepo;
import finki.ukim.mk.books.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserJpaRepo userJpaRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserJpaRepo userJpaRepo, PasswordEncoder passwordEncoder) {
        this.userJpaRepo = userJpaRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if (username== null || username.isEmpty() || password==null || password.isEmpty())
            throw  new IllegalArgumentException();
        if (!password.equals(repeatPassword))
            throw new IllegalArgumentException();
        if (this.userJpaRepo.findByUsername(username).isPresent())
            throw new IllegalArgumentException();
        User user=new User(username,passwordEncoder.encode(password),name,surname, role);
        return userJpaRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userJpaRepo.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));


    }

    @Override
    public User login(String username, String password) {
     
            if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
                throw new IllegalArgumentException();
            }
            return userJpaRepo.findByUsernameAndPassword(username,
                    password).orElseThrow(IllegalArgumentException::new);
        }


    }
}
