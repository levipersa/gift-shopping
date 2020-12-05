package com.pl.giftshop.repository;

import com.pl.giftshop.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
