package com.cumt.video.repository;

import com.cumt.video.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByuserName(String username);
}
