package ru.novotech.ThinkYou.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novotech.ThinkYou.user.model.User;


public interface UserJpaRepository extends JpaRepository<User, Long> {
}
