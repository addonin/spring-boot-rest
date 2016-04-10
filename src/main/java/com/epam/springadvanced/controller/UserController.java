package com.epam.springadvanced.controller;

import com.epam.springadvanced.domain.entity.Ticket;
import com.epam.springadvanced.domain.entity.User;
import com.epam.springadvanced.service.UserAccountService;
import com.epam.springadvanced.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author dmytro_adonin
 * @since 3/22/2016.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getUsersPage(ModelMap model) {
        return userService.getAll();
    }

    @RequestMapping(value = "/{userId}/tickets", method = RequestMethod.GET)
    public Collection<Ticket> getBookedTickets(@PathVariable("userId") int userId) {
        return userService.getBookedTickets(userId);
    }

    /*@RequestMapping(value = "/fill-account", params = {"userId", "amount"}, method = RequestMethod.POST)
    public String fillAccount(@RequestParam("userId") long userId,
                              @RequestParam("amount") float amount) {
        userAccountService.changeAmount(userId, amount);
        return "redirect:/users";
    }*/

}
