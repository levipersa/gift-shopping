package com.pl.giftshop.service;

import com.pl.giftshop.exceptions.NoUsersFoundExceptions;
import com.pl.giftshop.model.Users;
import com.pl.giftshop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UsersRepository usersRepository;

    public UserService(@Autowired UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public Users findById(Long id) {
        Optional<Users> user = usersRepository.findById(id);
        if (!user.isPresent()) {
            throw new NoUsersFoundExceptions("User with id: " + id + " was not found!");
        }
        return user.get();
    }

    public Users create(Users user) {

        return usersRepository.save(user);
    }




}
