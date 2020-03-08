package com.rtiwari.sales.repository;

import com.rtiwari.sales.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rtiwari
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findById(Long id);

    public void delete(Long id);

}
