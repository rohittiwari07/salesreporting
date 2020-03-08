package com.rtiwari.sales.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author rtiwari
 */
@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
            LOGGER.error("Username and Password is invalid");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
            LOGGER.debug("User has logged out successfully");
        }
        LOGGER.debug("Redirecting to the /login Page");
        return "login";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        LOGGER.debug("Redirecting to the /home Page");
        return "/secure/homePage";
    }

    @RequestMapping(value = {"/accounts"}, method = RequestMethod.GET)
    public String users(Model model) {
        LOGGER.debug("Redirecting to the /accounts  Page");
        return "/secure/accountsPage";
    }
}
