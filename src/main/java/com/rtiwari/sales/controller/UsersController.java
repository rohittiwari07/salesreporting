package com.rtiwari.sales.controller;

import com.rtiwari.sales.model.User;
import com.rtiwari.sales.service.user.UserService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rtiwari
 */
@Component
@ManagedBean
@SessionScoped
public class UsersController implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    private static final long serialVersionUID = 1L;
    private List<User> users;
    private User user;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        users = userService.getAllUsers();
        this.user = new User();
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
