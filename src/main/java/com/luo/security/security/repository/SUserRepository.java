package com.luo.security.security.repository;

import com.luo.security.security.entity.sUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SUserRepository  extends JpaRepository<sUser, Integer> {

    @Query("select u from sUser u where u.email=?1 and u.password=?2")
    sUser login(String email, String password);

    sUser findByEmailAndPassword(String email, String password);

    sUser findUserByEmail(String email);

}
