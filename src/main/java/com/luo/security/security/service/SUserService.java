package com.luo.security.security.service;

import com.luo.security.security.entity.sUser;
import com.luo.security.security.repository.SUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("suserService")
public class SUserService {


    @Autowired
    private SUserRepository suserRepository;

    public List<sUser> findAll() {
        return suserRepository.findAll();
    }

    public sUser create(sUser user) {
        return suserRepository.save(user);
    }

    public Optional<sUser> findUserById(int id) {
        return suserRepository.findById(id);
    }

    public sUser login(String email, String password) {
        return suserRepository.findByEmailAndPassword(email, password);
    }

    public sUser update(sUser user) {
        return suserRepository.save(user);
    }

    public void deleteUser(int id) {
        suserRepository.deleteById(id);
    }

    public sUser findUserByEmail(String email) {
        return suserRepository.findUserByEmail(email);
    }


}
