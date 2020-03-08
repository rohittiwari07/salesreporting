package com.rtiwari.sales.service.user;

import com.rtiwari.sales.model.User;
import java.util.List;

/**
 *
 * @author rtiwari
 */
public interface UserService {

    public void saveAdmin(User user);

    public User findByEmail(String email);

    public List getAllUsers();

    public void delete(Long id);

    public void edit(User user);
}
