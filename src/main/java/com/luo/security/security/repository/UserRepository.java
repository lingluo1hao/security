package com.luo.security.security.repository;

import com.luo.security.security.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User Repository 接口.
 * 
 * @since 1.0.0 2017年7月16日
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
