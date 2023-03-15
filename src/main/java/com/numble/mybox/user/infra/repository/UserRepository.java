package com.numble.mybox.user.infra.repository;

import com.numble.mybox.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
