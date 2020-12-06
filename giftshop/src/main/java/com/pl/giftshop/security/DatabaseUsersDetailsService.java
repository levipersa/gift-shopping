package com.pl.giftshop.security;

import com.pl.giftshop.exceptions.NoUsersFoundExceptions;
import com.pl.giftshop.model.Users;
import com.pl.giftshop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Component
public class DatabaseUsersDetailsService implements UserDetailsService {

    private UsersRepository usersRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    public DatabaseUsersDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws NoUsersFoundExceptions {

        Users user = usersRepository.findByUserName(username)
                .orElseThrow(()-> new NoUsersFoundExceptions(username));
        return new CustomUsersDetails(user);
    }

    public Optional<UserDetails> loadUserByJwtToken(String jwtToken) {

        if(jwtProvider.isTokenValid(jwtToken)) {
            return Optional.of(
                    withUsername(jwtProvider.getUsername(jwtToken))
                            .password("") // password should not be empty
                            .authorities(new ArrayList<>())
                            .accountExpired(false)
                            .accountLocked(false)
                            .credentialsExpired(false)
                            .disabled(false)
                            .build());
        }
        return Optional.empty();
    }

}
