package com.rtiwari.sales.service.user;

import com.rtiwari.sales.model.User;
import com.rtiwari.sales.repository.UserRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author rtiwari
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveAdmin(User user) {
        user.setEmail(user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPasswordconfirm(bCryptPasswordEncoder.encode(user.getPasswordconfirm()));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        LOGGER.debug("Email Value Passed : " + email);
        return userRepository.findByEmail(email);
    }

    @Override
    public List getAllUsers() {
        return (List) userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

}
